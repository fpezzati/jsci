package edu.fpezzati.jsfci.util;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class EntityManagerProducer {

	@Produces
	@GetEntityManager(unitName = "")
	@ApplicationScoped
	public EntityManager getEntityManager(InjectionPoint ip) {
		GetEntityManager getEntityManagerAnnotation = ip.getAnnotated().getAnnotation(GetEntityManager.class);
		EntityManager em = Persistence.createEntityManagerFactory(getEntityManagerAnnotation.unitName()).createEntityManager();
		return em;
	}

//	@Produces
//	@GetEntityManager(unitName = "")
//	public EntityManager getEntityManager(String persistenceUnitName) {
//		EntityManager em = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
//		return em;
//	}
}
