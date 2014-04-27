package de.siobra.exampleapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.siobra.exampleapp.models.Person;
import de.siobra.exampleapp.repositories.PersonRepository;

@Controller
public class PersonController {
@Autowired PersonRepository personRepository;
	
	@RequestMapping("/showperson/{lastName}")
	@ResponseBody
	String showPerson(@PathVariable String lastName) {
		Person personFind = personRepository.findByLastName(lastName);
		if(personFind != null) {
			return "Firstname: " + personFind.getFirstName() + " Lastname: " + personFind.getLastName();
		}
		return "No person with last name " + lastName + " found!";
	}
	
	@RequestMapping("/newperson")
	@ResponseBody
	String newPerson(@RequestParam String lastName, @RequestParam String firstName) {
		Person person = new Person(firstName, lastName);
		personRepository.save(person);
		
		return "Person with first name: " + firstName + " and last name: " + lastName + " saved!";
	}
}
