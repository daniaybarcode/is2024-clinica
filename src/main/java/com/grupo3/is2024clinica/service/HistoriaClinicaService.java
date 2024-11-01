package com.grupo3.is2024clinica.service;

import com.grupo3.is2024clinica.dto.HistoriaClinicaDTO;
import com.grupo3.is2024clinica.model.HistoriaClinica;
import com.grupo3.is2024clinica.repository.HistoriaClinicaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HistoriaClinicaService {

    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<HistoriaClinicaDTO> listarHistorias() {
        return historiaClinicaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public HistoriaClinicaDTO obtenerHistoriaPorId(Long id) {
        Optional<HistoriaClinica> historiaClinica = historiaClinicaRepository.findById(id);
        return historiaClinica.map(this::convertToDTO).orElse(null);
    }

    public HistoriaClinicaDTO guardarHistoria(HistoriaClinicaDTO historiaClinicaDTO) {
        HistoriaClinica historiaClinica = convertToEntity(historiaClinicaDTO);
        HistoriaClinica savedHistoria = historiaClinicaRepository.save(historiaClinica);
        return convertToDTO(savedHistoria);
    }

    public void eliminarHistoria(Long id) {
        historiaClinicaRepository.deleteById(id);
    }

    private HistoriaClinicaDTO convertToDTO(HistoriaClinica historiaClinica) {
        return modelMapper.map(historiaClinica, HistoriaClinicaDTO.class);
    }

    private HistoriaClinica convertToEntity(HistoriaClinicaDTO historiaClinicaDTO) {
        return modelMapper.map(historiaClinicaDTO, HistoriaClinica.class);
    }
}
