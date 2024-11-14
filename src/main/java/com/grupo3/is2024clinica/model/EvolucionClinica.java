package com.grupo3.is2024clinica.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "EvolucionClinica")
public class EvolucionClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvolucionClinica;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String textoLibre;

    @Column(nullable = false)
    private LocalDateTime fechaYhora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMedico", nullable = false)
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDiagnostico", nullable = false)
    private Diagnostico diagnostico;
}
