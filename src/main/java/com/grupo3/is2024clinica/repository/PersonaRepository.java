package com.grupo3.is2024clinica.repository;

import com.grupo3.is2024clinica.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    // Puedes agregar consultas personalizadas si es necesario
}
