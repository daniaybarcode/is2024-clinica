package com.grupo3.is2024clinica.controller;

import com.grupo3.is2024clinica.dto.PersonaDTO;
import com.grupo3.is2024clinica.model.Persona;
import com.grupo3.is2024clinica.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<PersonaDTO> getPersonas() {
        List<Persona> personas = personaService.findAll();
        return personas.stream()
                .map(PersonaDTO::new)  // Convertimos cada Persona en PersonaDTO
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaDTO> getPersonaById(@PathVariable Long id) {
        Optional<Persona> persona = personaService.findById(id);
        return persona.map(value -> ResponseEntity.ok(new PersonaDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PersonaDTO createPersona(@RequestBody Persona persona) {
        Persona savedPersona = personaService.save(persona);
        return new PersonaDTO(savedPersona);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaDTO> updatePersona(@PathVariable Long id, @RequestBody Persona persona) {
        return personaService.findById(id).map(existingPersona -> {
            persona.setIdPersona(existingPersona.getIdPersona());
            Persona updatedPersona = personaService.save(persona);
            return ResponseEntity.ok(new PersonaDTO(updatedPersona));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable Long id) {
        if (personaService.findById(id).isPresent()) {
            personaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
