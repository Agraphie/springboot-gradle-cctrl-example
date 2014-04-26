package de.siobra.exampleapp.models;

import org.springframework.data.annotation.Id;

public class Person {

	@Id
	private String id;
	
	private String firstName;
	private String  lastName;
	
	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
		
}
