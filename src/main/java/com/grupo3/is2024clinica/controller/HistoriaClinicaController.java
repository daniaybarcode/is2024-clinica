package com.grupo3.is2024clinica.controller;

import com.grupo3.is2024clinica.dto.HistoriaClinicaDTO;
import com.grupo3.is2024clinica.service.HistoriaClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historias-clinicas")
public class HistoriaClinicaController {

    @Autowired
    private HistoriaClinicaService historiaClinicaService;

    @GetMapping
    public List<HistoriaClinicaDTO> listarHistorias() {
        return historiaClinicaService.listarHistorias();
    }

    @GetMapping("/{id}")
    public HistoriaClinicaDTO obtenerHistoriaPorId(@PathVariable Long id) {
        return historiaClinicaService.obtenerHistoriaPorId(id);
    }

    @PostMapping
    public HistoriaClinicaDTO crearHistoria(@RequestBody HistoriaClinicaDTO historiaClinicaDTO) {
        return historiaClinicaService.guardarHistoria(historiaClinicaDTO);
    }

    @PutMapping("/{id}")
    public HistoriaClinicaDTO actualizarHistoria(@PathVariable Integer id, @RequestBody HistoriaClinicaDTO historiaClinicaDTO) {
        historiaClinicaDTO.setIdHistoriaClinica(id);
        return historiaClinicaService.guardarHistoria(historiaClinicaDTO);
    }

    @DeleteMapping("/{id}")
    public void eliminarHistoria(@PathVariable Long id) {
        historiaClinicaService.eliminarHistoria(id);
    }
}
