package com.grupo3.is2024clinica.service;

import com.grupo3.is2024clinica.dto.EvolucionClinicaDTO;
import com.grupo3.is2024clinica.model.Diagnostico;
import com.grupo3.is2024clinica.model.EvolucionClinica;
import com.grupo3.is2024clinica.model.Medico;
import com.grupo3.is2024clinica.repository.DiagnosticoRepository;
import com.grupo3.is2024clinica.repository.EvolucionClinicaRepository;
import com.grupo3.is2024clinica.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EvolucionClinicaService {

    @Autowired
    private EvolucionClinicaRepository evolucionClinicaRepository;

    @Autowired
    private DiagnosticoRepository diagnosticoRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    public List<EvolucionClinicaDTO> listarEvolucionesPorDiagnostico(Integer idDiagnostico) {
        return evolucionClinicaRepository.findByDiagnostico_IdDiagnostico(idDiagnostico)
                .stream()
                .map(EvolucionClinicaDTO::new)
                .collect(Collectors.toList());
    }

    public EvolucionClinicaDTO crearEvolucionClinica(EvolucionClinicaDTO evolucionClinicaDTO) {
        Optional<Diagnostico> diagnostico = diagnosticoRepository.findById(evolucionClinicaDTO.getIdDiagnostico());
        Optional<Medico> medico = medicoRepository.findById(Long.valueOf(evolucionClinicaDTO.getIdMedico()));

        if (diagnostico.isPresent() && medico.isPresent()) {
            EvolucionClinica evolucionClinica = new EvolucionClinica();
            evolucionClinica.setTextoLibre(evolucionClinicaDTO.getTextoLibre());
            evolucionClinica.setFechaYhora(evolucionClinicaDTO.getFechaYhora());
            evolucionClinica.setDiagnostico(diagnostico.get());
            evolucionClinica.setMedico(medico.get());

            evolucionClinica = evolucionClinicaRepository.save(evolucionClinica);
            return new EvolucionClinicaDTO(evolucionClinica);
        }
        return null; // O lanzar una excepción si prefieres manejar errores
    }
}
