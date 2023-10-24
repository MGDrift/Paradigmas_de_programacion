package com.paradigmas.subasta.service;

import com.paradigmas.subasta.model.Persona;

import java.util.List;

public interface PersonaService {
    public void createOrUpdatePersons(Persona emp);

    public List<Persona> getAllPersons();

    public void deletePerson(String id);

    public Persona editPerson(String id);
}
