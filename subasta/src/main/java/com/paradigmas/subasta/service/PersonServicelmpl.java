package com.paradigmas.subasta.service;

import com.paradigmas.subasta.model.Person;
import com.paradigmas.subasta.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServicelmpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getById(String id) {
        return personRepository.findById(id).orElse(new Person());
    }

    public Person createOrUpdatePerson(Person person) {
        return personRepository.save(person);
    }

    public void deletePerson(String id) {
        personRepository.deleteById(id);
    }
}
