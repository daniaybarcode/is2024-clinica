package com.grupo3.is2024clinica.repository;

import com.grupo3.is2024clinica.model.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiagnosticoRepository extends JpaRepository<Diagnostico, Integer> {
    List<Diagnostico> findByHistoriaClinica_IdHistoriaClinica(Integer idHistoriaClinica);
    // Métodos adicionales de consulta si es necesario
}
