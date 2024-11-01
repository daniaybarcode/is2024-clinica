package com.grupo3.is2024clinica.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "HistoriaClinica")
@Getter
@Setter
@NoArgsConstructor
public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistoriaClinica;

    private LocalDate fechaCreado;
    private Long idPaciente;
    private String descripcion;

    // Lombok generará automáticamente los getters y setters
}
