package edu.fpezzati.jsfci;

import java.util.Date;

import javax.inject.Named;

@Named(value = "helloworld")
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
