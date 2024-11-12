package com.grupo3.is2024clinica.service;

import com.grupo3.is2024clinica.dto.DiagnosticoDTO;
import com.grupo3.is2024clinica.model.Diagnostico;
import com.grupo3.is2024clinica.repository.DiagnosticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DiagnosticoService {

    @Autowired
    private DiagnosticoRepository diagnosticoRepository;

    public DiagnosticoDTO obtenerDiagnosticoPorId(Integer id) {
        Optional<Diagnostico> diagnostico = diagnosticoRepository.findById(id);
        return diagnostico.map(DiagnosticoDTO::new).orElse(null);
    }

    public DiagnosticoDTO crearDiagnostico(DiagnosticoDTO diagnosticoDTO) {
        Diagnostico diagnostico = new Diagnostico();
        diagnostico.setEnfermedad(diagnosticoDTO.getEnfermedad());
        diagnostico.setObservaciones(diagnosticoDTO.getObservaciones());
        // Suponiendo que hay una lógica para setear HistoriaClinica
        // diagnostico.setHistoriaClinica(historiaClinicaRepository.findById(diagnosticoDTO.getIdHistoriaClinica()).orElse(null));

        diagnostico = diagnosticoRepository.save(diagnostico);
        return new DiagnosticoDTO(diagnostico);
    }
    public List<DiagnosticoDTO> listarDiagnosticosPorHistoriaClinica(Integer idHistoriaClinica) {
        return diagnosticoRepository.findByHistoriaClinica_IdHistoriaClinica(idHistoriaClinica)
                .stream()
                .map(DiagnosticoDTO::new)
                .collect(Collectors.toList());
    }
}
