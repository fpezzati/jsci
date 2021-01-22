package edu.fpezzati.jsfci.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private UUID id;

	@Column
	private String name;

	@Column
	private String surname;

	@Column
	private int age;

	@Column
	private Date since;

	public UUID getId() {
		return id;
	}

	public User setId(UUID id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public User setName(String name) {
		this.name = name;
		return this;
	}

	public String getSurname() {
		return surname;
	}

	public User setSurname(String surname) {
		this.surname = surname;
		return this;
	}

	public int getAge() {
		return age;
	}

	public User setAge(int age) {
		this.age = age;
		return this;
	}

	public Date getSince() {
		return since;
	}

	public User setSince(Date since) {
		this.since = since;
		return this;
	}
}
