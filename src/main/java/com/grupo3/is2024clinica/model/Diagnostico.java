package com.grupo3.is2024clinica.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Diagnostico")
public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDiagnostico;

    @Column(length = 100, nullable = false)
    private String enfermedad;

    @Column(columnDefinition = "TEXT")
    private String observaciones;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idHistoriaClinica", nullable = false)
    private HistoriaClinica historiaClinica; // Suponiendo que existe la entidad HistoriaClinica
}
