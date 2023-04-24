package br.com.cursojava.projeto.integracao.jpa.repository;

import br.com.cursojava.projeto.negocio.modelo.interfaces.IEntidade;
import br.com.cursojava.projeto.sistema.excecoes.AppException;

import java.util.List;

public interface IRepository <E extends IEntidade>{
    Long count(E filter) throws AppException;
    List<E> findAll() throws AppException;
    List<E> find(E filter, Object... extraFilters) throws AppException;
    List<E> find(E filter, int page, int pageSize, String orderBy, Object... extraFilters) throws AppException;
    E findById(Long id) throws AppException;
    E insert(E entity) throws AppException;
    E update(E entity) throws AppException;
    void delete(E entity) throws AppException;
    Class<E> getEntityClass() throws AppException;
    E getEntityInstance() throws AppException;
}