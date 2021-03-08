package edu.fpezzati.jsfci.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "generic_good")
public class GenericGood {

	@Id
	@Column(name = "id")
	private UUID id;

	@Column(name = "description")
	@Size(max = 100)
	@NotNull
	private String descr;
}
