package com.grupo3.is2024clinica.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Medico")
@Getter
@Setter
@NoArgsConstructor
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedico;

    @Column(nullable = false, unique = true)
    private String matricula;

    @Column(nullable = false)
    private String especialidad;

    @OneToOne
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersona")
    private Persona persona;
}
