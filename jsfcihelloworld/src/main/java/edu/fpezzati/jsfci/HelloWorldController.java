package edu.fpezzati.jsfci;

import java.util.Date;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@Named(value = "helloworld")
@RequestScoped
public class HelloWorldController {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Date currentTime() {
		return new Date();
	}
}
