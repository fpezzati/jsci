package edu.fpezzati.jsfci.model.task;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class MoveSomethingFromAToB extends Task {

	private static final long serialVersionUID = 2490152011240832084L;

	@OneToMany
	@JoinTable(name = "move_something_complex",
		joinColumns = { @JoinColumn(name = "main_task") },
		inverseJoinColumns = { @JoinColumn(name = "component_task") })
	private List<Task> tasks;

	@Override
	public List<Task> getTasks() {
		return tasks;
	}
}
