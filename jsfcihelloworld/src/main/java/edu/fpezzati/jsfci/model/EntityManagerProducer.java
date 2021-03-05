package edu.fpezzati.jsfci.model;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

public class EntityManagerProducer {

	@PersistenceUnit(unitName = "jscihw")
	private EntityManagerFactory emf;

	@Produces
	@ApplicationScoped
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
