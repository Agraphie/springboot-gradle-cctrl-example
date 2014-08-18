package de.siobra.exampleapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.siobra.exampleapp.models.Person;
import de.siobra.exampleapp.repositories.PersonRepository;

import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class PersonController {
@Autowired PersonRepository personRepository;
	
	@RequestMapping(value = "/persons/{lastName}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	List<Person> showPersons(@PathVariable String lastName) {
		if(lastName != null && !lastName.isEmpty()) {
			return personRepository.findByLastName(lastName);
		}
		return personRepository.findAll();
	}
	
	@RequestMapping(value ="/persons", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	List<Person> showPersons() {
		return personRepository.findAll();
	}
	
	@RequestMapping(value = "/persons", produces = MediaType.TEXT_HTML_VALUE)
	String showPersonsView() {
		return "persons";
	}
	
	@RequestMapping(value = "/persons", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	Person newPerson(@ModelAttribute Person person) {
		person = personRepository.save(person);
		
		return person;
	}
}
