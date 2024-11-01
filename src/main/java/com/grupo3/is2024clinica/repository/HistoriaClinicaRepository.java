// Ubicación: src/main/java/com/grupo3/is2024clinica/repository/HistoriaClinicaRepository.java
package com.grupo3.is2024clinica.repository;

import com.grupo3.is2024clinica.model.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriaClinicaRepository extends JpaRepository<HistoriaClinica, Long> {
}
//