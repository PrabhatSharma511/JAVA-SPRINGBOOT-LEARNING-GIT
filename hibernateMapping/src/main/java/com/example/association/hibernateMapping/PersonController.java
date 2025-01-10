package com.example.association.hibernateMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@Autowired
	PersonRepository personRepository;
	@Autowired
	AddressRepository adrrepo;
	
	@PostMapping("/person")
	public Person insertPerson(@RequestBody Person person) {
		for(Address adress:person.getAddress()) {
			adress.setPerson(person);
			adrrepo.save(adress);
		}
		return personRepository.save(person);
	}
	
	@GetMapping("/person")
	public List<Person> getPersons(){
		return personRepository.findAll();
	}
	
	
}
