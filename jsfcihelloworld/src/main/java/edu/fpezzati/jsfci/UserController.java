package edu.fpezzati.jsfci;

import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import edu.fpezzati.jsfci.model.User;

@Named(value = "usercontroller")
@ViewScoped
public class UserController {

	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
