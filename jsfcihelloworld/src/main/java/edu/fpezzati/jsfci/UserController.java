package edu.fpezzati.jsfci;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import edu.fpezzati.jsfci.model.User;

@Named(value = "usercontroller")
@ApplicationScoped
public class UserController {

	private List<User> users;

	@Inject
	private EntityManager em;

	public UserController() {
		users = new ArrayList<User>();
		users.add(new User().setId(UUID.nameUUIDFromBytes("jim.bent".getBytes())).setAge(1).setName("jim").setSurname("bent").setSince(new Date()));
		users.add(new User().setId(UUID.nameUUIDFromBytes("joe.bent".getBytes())).setAge(2).setName("joe").setSurname("bent").setSince(new Date()));
		users.add(new User().setId(UUID.nameUUIDFromBytes("jay.bent".getBytes())).setAge(3).setName("jay").setSurname("bent").setSince(new Date()));
		users.add(new User().setId(UUID.nameUUIDFromBytes("jeez.bent".getBytes())).setAge(4).setName("jeez").setSurname("bent").setSince(new Date()));
		users.add(new User().setId(UUID.nameUUIDFromBytes("jack.bent".getBytes())).setAge(5).setName("jack").setSurname("bent").setSince(new Date()));
		users.add(new User().setId(UUID.nameUUIDFromBytes("jona.bent".getBytes())).setAge(10).setName("jona").setSurname("bent").setSince(new Date()));
	}

	public List<User> getUsers() {
		em.createQuery("select * from users", User.class);
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public boolean isEditable(User user) {
		return true;
	}

	public String getEditLink(User user) {
		return "./edit.xhtml?id="+user.getId().toString();
	}

	public User getUserById(String id) {
		User user;
		Optional<User> result = users.stream().filter(usr -> usr.getId().equals(UUID.fromString(id))).findAny();
		if(result.isPresent()) {
			user = result.get();
		} else {
			user = new User();
		}
		return user;
	}
}
