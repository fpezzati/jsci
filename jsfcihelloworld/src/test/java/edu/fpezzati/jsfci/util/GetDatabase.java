package edu.fpezzati.jsfci.util;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class GetDatabase implements BeforeAllCallback, AfterAllCallback {

	private EntityManager em;
	private String unitName;

	public GetDatabase(String unitName) {
		this.unitName = unitName;
	}

	@Override
	public void afterAll(ExtensionContext context) throws Exception {
		em = Persistence.createEntityManagerFactory(unitName).createEntityManager();
		context.getStore(Namespace.GLOBAL).put("entity.manager", em);
	}

	@Override
	public void beforeAll(ExtensionContext context) throws Exception {
		em.close();
	}
}
