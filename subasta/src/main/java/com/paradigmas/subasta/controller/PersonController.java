package com.paradigmas.subasta.controller;

import com.paradigmas.subasta.model.Person;
import com.paradigmas.subasta.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping("/list")
	public ResponseEntity<List<Person>> getAllPersons() {
		var persons = personService.getAllPersons();
		return ResponseEntity.ok(persons);
	}

	@GetMapping
	public ResponseEntity<Person> getById(@RequestParam("id") String id) {
		var persons = personService.getById(id);
		return ResponseEntity.ok(persons);
	}

	@PostMapping
	public ResponseEntity<Person> createAuction(@RequestBody Person person) {
		var personSaved = personService.createOrUpdatePerson(person);
		return ResponseEntity.ok(personSaved);
	}

	@DeleteMapping
	public ResponseEntity deleteAuction(@RequestParam("id") String id) {
		personService.deletePerson(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping
	public ResponseEntity<Person> updateAuction(@RequestBody Person person) {
		var personSaved = personService.createOrUpdatePerson(person);
		return ResponseEntity.ok(personSaved);
	}
	
}
