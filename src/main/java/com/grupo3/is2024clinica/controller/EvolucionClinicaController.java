package com.grupo3.is2024clinica.controller;

import com.grupo3.is2024clinica.dto.EvolucionClinicaDTO;
import com.grupo3.is2024clinica.service.EvolucionClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evoluciones-clinicas")
public class EvolucionClinicaController {

    @Autowired
    private EvolucionClinicaService evolucionClinicaService;

    @GetMapping("/diagnostico/{idDiagnostico}")
    public List<EvolucionClinicaDTO> listarEvolucionesPorDiagnostico(@PathVariable Integer idDiagnostico) {
        return evolucionClinicaService.listarEvolucionesPorDiagnostico(idDiagnostico);
    }

    @PostMapping
    public EvolucionClinicaDTO crearEvolucionClinica(@RequestBody EvolucionClinicaDTO evolucionClinicaDTO) {
        return evolucionClinicaService.crearEvolucionClinica(evolucionClinicaDTO);
    }
}
