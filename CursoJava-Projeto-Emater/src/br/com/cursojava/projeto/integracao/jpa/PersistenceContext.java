package br.com.cursojava.projeto.integracao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceContext {
    private static EntityManagerFactory emfInstance;

    private static EntityManagerFactory getEmfInstance() { return emfInstance; }

    private static void setEmfInstance() {
        PersistenceContext.emfInstance = Persistence.createEntityManagerFactory("Modulo-2-JPA");
    }

    public static EntityManager getEntityManager() {
        if (getEmfInstance() == null) setEmfInstance();
        return getEmfInstance().createEntityManager();
    }

    public static void close(){
        if(getEmfInstance() != null)
            getEmfInstance().close();
    }
}