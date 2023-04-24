package br.com.cursojava.projeto.integracao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PostegreSqlJpaApp {
	public static void testePersistenceContext() {
		EntityManager em = PersistenceContext.getEntityManager();
		printTesteSimples(em);
		em.close();
		PersistenceContext.close();
	}

	public static void testeJpa() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Modulo-2-JPA");
		EntityManager em = emf.createEntityManager();
		printTesteSimples(em);
		em.close();
		emf.close();
	}

	private static void printTesteSimples(EntityManager em) {
		System.out.println(em.createNativeQuery("SELECT 1 AS TEST").getSingleResult());
	}
}