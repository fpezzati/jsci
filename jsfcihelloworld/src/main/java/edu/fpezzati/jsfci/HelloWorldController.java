package edu.fpezzati.jsfci;

import java.util.Date;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named(value = "helloworld")
@ViewScoped
public class HelloWorldController {

	private String name;

	public String getName() {
		System.out.println("getName(): " + name);
		return name;
	}

	public void setName(String name) {
		System.out.println("setName(): " + name);
		this.name = name;
	}

	public Date currentTime() {
		return new Date();
	}
}
