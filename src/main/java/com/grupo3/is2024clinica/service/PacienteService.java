package com.grupo3.is2024clinica.service;

import com.grupo3.is2024clinica.model.Paciente;
import com.grupo3.is2024clinica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> obtenerTodos() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> obtenerPorId(Long id) {
        return pacienteRepository.findById(id);
    }

    public Paciente guardar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public void eliminar(Long id) {
        pacienteRepository.deleteById(id);
    }

    public Paciente actualizar(Long id, Paciente pacienteActualizado) {
        if (pacienteRepository.existsById(id)) {
            pacienteActualizado.setIdPaciente(id);
            return pacienteRepository.save(pacienteActualizado);
        }
        throw new RuntimeException("Paciente no encontrado con id: " + id);
    }
}
