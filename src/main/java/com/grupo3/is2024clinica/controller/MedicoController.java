// src/main/java/com/grupo3/is2024clinica/controller/MedicoController.java
package com.grupo3.is2024clinica.controller;

import com.grupo3.is2024clinica.model.Medico;
import com.grupo3.is2024clinica.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public List<Medico> obtenerTodos() {
        return medicoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> obtenerPorId(@PathVariable Long id) {
        return medicoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Medico> crear(@RequestBody Medico medico) {
        Medico nuevoMedico = medicoService.guardar(medico);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoMedico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> actualizar(@PathVariable Long id, @RequestBody Medico medicoActualizado) {
        try {
            Medico actualizado = medicoService.actualizar(id, medicoActualizado);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (medicoService.obtenerPorId(id).isPresent()) {
            medicoService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
