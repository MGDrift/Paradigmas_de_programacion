package com.paradigmas.subasta.service;

import com.paradigmas.subasta.model.Persona;
import com.paradigmas.subasta.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServicelmpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public void createOrUpdatePersons(Persona persona) {
        personaRepository.save(persona);
    }

    public List<Persona> getAllPersons() {
        return personaRepository.findAll();
    }

    public void deletePerson(String id) {
        personaRepository.deleteById(id);
    }

    public Persona editPerson(String id) {
        return personaRepository.findById(id).orElse(new Persona());
    }
}
