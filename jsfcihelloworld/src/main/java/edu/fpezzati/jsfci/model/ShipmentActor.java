package edu.fpezzati.jsfci.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "shipment_actor")
public class ShipmentActor implements Serializable {

	private static final long serialVersionUID = -7849529080576382149L;

	@Id
	private UUID id;

	@Column
	@Size(max = 100)
	private String description;

	@Column
	private Date since;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getSince() {
		return since;
	}

	public void setSince(Date since) {
		this.since = since;
	}
}
