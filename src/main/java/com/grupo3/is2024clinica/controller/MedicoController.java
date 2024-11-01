package com.grupo3.is2024clinica.controller;

import com.grupo3.is2024clinica.dto.MedicoDTO;
import com.grupo3.is2024clinica.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public List<MedicoDTO> getAllMedicos() {
        return medicoService.getAllMedicos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDTO> getMedicoById(@PathVariable Long id) {
        MedicoDTO medicoDTO = medicoService.getMedicoById(id);
        return medicoDTO != null ? ResponseEntity.ok(medicoDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public MedicoDTO createMedico(@RequestBody MedicoDTO medicoDTO) {
        return medicoService.createMedico(medicoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicoDTO> updateMedico(@PathVariable Long id, @RequestBody MedicoDTO medicoDTO) {
        MedicoDTO updatedMedico = medicoService.updateMedico(id, medicoDTO);
        return updatedMedico != null ? ResponseEntity.ok(updatedMedico) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedico(@PathVariable Long id) {
        medicoService.deleteMedico(id);
        return ResponseEntity.noContent().build();
    }
}
