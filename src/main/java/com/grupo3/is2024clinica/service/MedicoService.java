package com.grupo3.is2024clinica.dto;



import com.grupo3.is2024clinica.model.Medico;
import com.grupo3.is2024clinica.model.Persona;
import com.grupo3.is2024clinica.repository.MedicoRepository;
import com.grupo3.is2024clinica.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PersonaRepository personaRepository;

    public List<MedicoDTO> getAllMedicos() {
        return medicoRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public MedicoDTO getMedicoById(Long idMedico) {
        return medicoRepository.findById(idMedico)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Transactional
    public MedicoDTO createMedico(MedicoDTO medicoDTO) {
        Persona persona = personaRepository.findById(medicoDTO.getCuilPersona())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        Medico medico = new Medico();
        medico.setMatricula(medicoDTO.getMatricula());
        medico.setEspecialidad(medicoDTO.getEspecialidad());
        medico.setPersona(persona);

        Medico savedMedico = medicoRepository.save(medico);
        return convertToDTO(savedMedico);
    }

    @Transactional
    public MedicoDTO updateMedico(Long idMedico, MedicoDTO medicoDTO) {
        Medico medico = medicoRepository.findById(idMedico)
                .orElseThrow(() -> new RuntimeException("Médico no encontrado"));

        Persona persona = personaRepository.findById(medicoDTO.getCuilPersona())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        medico.setMatricula(medicoDTO.getMatricula());
        medico.setEspecialidad(medicoDTO.getEspecialidad());
        medico.setPersona(persona);

        Medico updatedMedico = medicoRepository.save(medico);
        return convertToDTO(updatedMedico);
    }

    @Transactional
    public void deleteMedico(Long idMedico) {
        medicoRepository.deleteById(idMedico);
    }

    private MedicoDTO convertToDTO(Medico medico) {
        MedicoDTO dto = new MedicoDTO();
        dto.setIdMedico(medico.getIdMedico());
        dto.setMatricula(medico.getMatricula());
        dto.setEspecialidad(medico.getEspecialidad());
        dto.setCuilPersona(medico.getPersona().getCuil());
        return dto;
    }
}
