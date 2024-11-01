package com.grupo3.is2024clinica.repository;

import com.grupo3.is2024clinica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    // Métodos personalizados, si es necesario
}
