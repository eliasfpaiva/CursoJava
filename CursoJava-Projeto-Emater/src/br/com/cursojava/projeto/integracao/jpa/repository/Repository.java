package br.com.cursojava.projeto.integracao.jpa.repository;

import br.com.cursojava.projeto.integracao.jpa.PersistenceContext;
import br.com.cursojava.projeto.negocio.modelo.interfaces.IEntidade;
import br.com.cursojava.projeto.sistema.excecoes.AppException;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Repository<E extends IEntidade> implements IRepository<E> {

    private EntityManager entityManager;

    protected Repository() { this.entityManager = PersistenceContext.getEntityManager(); }

    @Override
    public Long count(E filter) throws AppException {
        Map<String, Object> filtroInMap = buildMapFiltro(filter);
        String queryStr = String.format(
                "SELECT COUNT(e) FROM %s e WHERE 1=1 %s",
                this.getEntityClass().getSimpleName(),
                this.buildQueryWithWhereClause(filtroInMap));

        Query queryObj = this.entityManager.createQuery(queryStr, Long.class);
        this.setQueryParameters(queryObj, filtroInMap);

        return (Long) queryObj.getSingleResult();
    }

    @Override
    public E findById(Long id) throws AppException {
        // validation
        if (id == null) {
            throw new AppException("error.find.id.validation");
        }
        // execute
        try {
            E entity = this.entityManager.find(this.getEntityClass(), id);
            if (entity == null) {
                throw new AppException("error.find.id.not.found");
            }
            return entity;
        } catch (Exception ex) {
            throw new AppException("error.find.id.exception", ex);
        }
    }

    @Override
    public List<E> findAll() throws AppException {
        return this.find(this.getEntityInstance());
    }

    @Override
    public List<E> find(E filter, Object... extraFilters) throws AppException {
        return this.find(filter, 0, 0, null, extraFilters);
    }

    @Override
    public List<E> find(E filter, int page, int pageSize, String orderBy, Object... extraFilters) throws AppException {
        // validation
        if (filter == null) {
            throw new AppException("error.find.validation");
        }
        // execute
        try {
            Map<String, Object> filtroInMap = buildMapFiltro(filter);
            String queryStr = String.format(
                    " SELECT entity FROM %s entity %s WHERE 1=1 %s %s",
                    this.getEntityClass().getSimpleName(),
                    this.buildFromClauseExtension(filter),
                    this.buildQueryWithWhereClause(filtroInMap),
                    this.buildQueryWithOrderByClause(orderBy));

            Query queryObj = this.entityManager.createQuery(queryStr, this.getEntityClass());
            this.setQueryParameters(queryObj, filtroInMap);
            this.setPagination(queryObj, page, pageSize);

            @SuppressWarnings("unchecked")
            List<E> resultList = queryObj.getResultList();
            return resultList;

        } catch (Exception ex) {
            throw new AppException("error.find.exception", ex);
        }
    }

    @Override
    public E insert(E entity) throws AppException {
        // validate
        if (entity == null || entity.getId() != null) {
            throw new AppException("error.insert.validation");
        }
        // execute
        EntityTransaction transaction = this.entityManager.getTransaction();
        try {
            transaction.begin();
            this.entityManager.persist(entity);
            transaction.commit();
            return entity;
        } catch (Exception ex) {
            transaction.rollback();
            throw new AppException("error.insert.rollback", ex);
        }
    }

    @Override
    public E update(E entity) throws AppException {
        // validate
        if (entity == null || entity.getId() == null) {
            throw new AppException("error.update.validation");
        }
        // execute
        EntityTransaction transaction = this.entityManager.getTransaction();
        try {
            transaction.begin();
            entity = this.entityManager.merge(entity);
            transaction.commit();
            return entity;
        } catch (Exception ex) {
            transaction.rollback();
            throw new AppException("error.update.rollback", ex);
        }
    }

    @Override
    public void delete(E entity) throws AppException {
        // validate
        if (entity == null || entity.getId() == null) {
            throw new AppException("error.delete.validation");
        }
        // execute
        EntityTransaction transaction = this.entityManager.getTransaction();
        try {
            transaction.begin();
            this.entityManager.remove(entity);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            throw new AppException("error.delete.rollback", ex);
        }

    }

    protected String buildFromClauseExtension(E filter) {
        // this method should be overridden by subclasses (concrete repositories)
        return "";
    }

    protected String buildQueryWithWhereClause(Map<String, Object> filtro) {
        if (filtro.isEmpty()) return "";

        return filtro.entrySet().stream().map(e -> {
            boolean valorString = e.getValue().getClass().equals(String.class);
            return String.format(" AND %s %s :%s%s ",
                    e.getKey(),
                    valorString ? "LIKE" : "=",
                    e.getValue(),
                    valorString ? "%" : "");
        }).collect(Collectors.joining());
    }

    protected void setQueryParameters(Query query, Map<String, Object> filtro) {
        if (filtro.isEmpty()) return;

        filtro.forEach(query::setParameter);
    }

    private void setPagination(Query query, int page, int pageSize) {
        // page [1..N] and pageSize
        if (page > 0 && pageSize > 0) {
            query.setFirstResult((page - 1) * pageSize);
            query.setMaxResults(page);
        }
    }

    private String buildQueryWithOrderByClause(String orderBy) {
        String queryStr = "";
        // sort option
        if (orderBy == null || orderBy.isEmpty()) {
            orderBy = getDefaultOrderBy();
        }

        if (orderBy != null && !orderBy.isEmpty()) {
            queryStr += " ORDER BY " + orderBy;
        }
        return queryStr;
    }

    protected String getDefaultOrderBy() {
        return "id DESC" ;
    }

    public E setTestSampleToInsert(E entity) {
        return entity;
    }

    public E setTestSampleToUpdate(E entity) {
        return entity;
    }

    private Map<String, Object> buildMapFiltro(E filter) {
        return Arrays.stream(this.getClass().getDeclaredFields())
                .filter(f -> (f.getDeclaredAnnotations().length == 0))
                .collect(Collectors.toUnmodifiableMap(Field::getName, f -> {
                    f.setAccessible(true);
                    try {
                        return f.get(filter);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }));
    }
}