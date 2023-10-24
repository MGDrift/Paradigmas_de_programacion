package com.paradigmas.subasta.controller;

import com.paradigmas.subasta.model.Persona;
import com.paradigmas.subasta.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/persona")
public class PersonaController {

	@Autowired
	private PersonaService personaService;
	
	@GetMapping(value = {"/","/registration"})
	public String registration(Map<String, Object> model) {
		model.put("persona", new Persona());
		return "persona-add-update";
	}
	
	@PostMapping("/home")
	public String createPersona
			(@ModelAttribute("persona") Persona personaDto) {
		personaService.createOrUpdatePersons(personaDto);
		return "redirect:/list";	
	}
	
	@GetMapping("/list")
	public String listOfPersona(Model model) {
		List<Persona> personaList = personaService.getAllPersons();
		model.addAttribute("personaList", personaList);
		return "persona-list";
	}
	
	@PostMapping("/delete")
	public String deletePersona(@RequestParam("id") String id) {
		personaService.deletePerson(id);
		return "redirect:/list";		
	}
	
	@GetMapping("/edit")
	public String editPersona(
			@RequestParam("id") String id, Map<String, Object> model) {
		Persona persona = personaService
				.editPerson(id);
		model.put("persona", persona);
		return "persona-add-update";
	}
	
}
