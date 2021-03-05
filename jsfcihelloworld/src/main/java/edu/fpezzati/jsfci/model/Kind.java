package edu.fpezzati.jsfci.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kind")
public class Kind implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private UUID id;

	@Column
	private String name;

	public UUID getId() {
		return id;
	}

	public Kind setId(UUID id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Kind setName(String name) {
		this.name = name;
		return this;
	}
}
