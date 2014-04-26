package de.siobra.exampleapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.siobra.exampleapp.models.Person;
import de.siobra.exampleapp.repositories.PersonRepository;

@Controller
public class HelloWorldController {
	@Autowired PersonRepository personRepository;
	
	@RequestMapping("/person")
	@ResponseBody
	String showPerson() {
		Person person = personRepository.findByLastName("Smith");
		return "Firstname: " + person.getFirstName() + " Lastname: " + person.getLastName();
	}

	@RequestMapping("/hello")
	@ResponseBody
	String sayHello() {
		return "Hello!";
	}
}
