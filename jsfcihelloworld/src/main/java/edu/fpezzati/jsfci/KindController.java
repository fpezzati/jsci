package edu.fpezzati.jsfci;

import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;

import edu.fpezzati.jsfci.model.Kind;

@Named(value = "kindcontroller")
@ApplicationScoped
public class KindController {

	@PersistenceUnit(unitName = "jscihw")
	private EntityManager em;

	public List<Kind> getKinds() {
		return em.createQuery("select k from Kind k", Kind.class).getResultList();
	}

	public boolean isEditable(Kind kind) {
		return true;
	}

	public String getEditLink(Kind kind) {
		return "./edit.xhtml?id="+kind.getId().toString();
	}

	public Kind getKindById(String id) {
		return em.find(Kind.class, UUID.fromString(id));
	}
}
