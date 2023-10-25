package com.paradigmas.subasta.service;

import com.paradigmas.subasta.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAllPersons();

    Person getById(String id);
    Person createOrUpdatePerson(Person emp);

    void deletePerson(String id);
}
