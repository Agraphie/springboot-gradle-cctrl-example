package de.siobra.exampleapp.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import de.siobra.exampleapp.models.Person;

public interface PersonRepository extends MongoRepository<Person, String> {
	
	public List<Person> findByLastName(String lastName);
	public List<Person> findByFirstName(String firstName);
}
