// src/main/java/com/grupo3/is2024clinica/service/MedicoService.java
package com.grupo3.is2024clinica.service;

import com.grupo3.is2024clinica.model.Medico;
import com.grupo3.is2024clinica.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> obtenerTodos() {
        return medicoRepository.findAll();
    }

    public Optional<Medico> obtenerPorId(Long id) {
        return medicoRepository.findById(id);
    }

    public Medico guardar(Medico medico) {
        return medicoRepository.save(medico);
    }

    public void eliminar(Long id) {
        medicoRepository.deleteById(id);
    }

    public Medico actualizar(Long id, Medico medicoActualizado) {
        if (medicoRepository.existsById(id)) {
            medicoActualizado.setIdMedico(id);
            return medicoRepository.save(medicoActualizado);
        }
        throw new RuntimeException("Medico no encontrado con id: " + id);
    }
}
