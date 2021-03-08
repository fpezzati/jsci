package edu.fpezzati.jsfci.model.task;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "move_something")
public abstract class Task implements Serializable {

	private static final long serialVersionUID = 3982223739017643309L;

	@Id
	@Column(name = "id")
	private UUID id;

	@Column(name = "starts_at")
	private Date startsAt;

	@Column(name = "ends_at")
	private Date endsAt;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Date startsAt() {
		return startsAt;
	}

	public void setStartsAt(Date startsAt) {
		this.startsAt = startsAt;
	}

	public Date endsAt() {
		return endsAt;
	}

	public void setEndsAt(Date endsAt) {
		this.endsAt = endsAt;
	}

	public abstract List<Task> getTasks();
}
