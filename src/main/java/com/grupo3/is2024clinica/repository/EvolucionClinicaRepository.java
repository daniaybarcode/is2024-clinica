package com.grupo3.is2024clinica.repository;

import com.grupo3.is2024clinica.model.EvolucionClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvolucionClinicaRepository extends JpaRepository<EvolucionClinica, Integer> {
    List<EvolucionClinica> findByDiagnostico_IdDiagnostico(Integer idDiagnostico);
}
