package com.grupo3.is2024clinica.controller;

import com.grupo3.is2024clinica.dto.DiagnosticoDTO;
import com.grupo3.is2024clinica.service.DiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diagnosticos")
public class DiagnosticoController {

    @Autowired
    private DiagnosticoService diagnosticoService;

    @GetMapping("/{id}")
    public DiagnosticoDTO obtenerDiagnostico(@PathVariable Integer id) {
        return diagnosticoService.obtenerDiagnosticoPorId(id);
    }

    @PostMapping
    public DiagnosticoDTO crearDiagnostico(@RequestBody DiagnosticoDTO diagnosticoDTO) {
        return diagnosticoService.crearDiagnostico(diagnosticoDTO);
    }

    @GetMapping("/historia-clinica/{idHistoriaClinica}")
    public List<DiagnosticoDTO> listarDiagnosticosPorHistoriaClinica(@PathVariable Integer idHistoriaClinica) {
        return diagnosticoService.listarDiagnosticosPorHistoriaClinica(idHistoriaClinica);
    }
}
