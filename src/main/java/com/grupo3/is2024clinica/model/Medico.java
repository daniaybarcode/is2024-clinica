// src/main/java/com/grupo3/is2024clinica/model/Medico.java
package com.grupo3.is2024clinica.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedico;

    @OneToOne(fetch = FetchType.EAGER)  // Puedes usar EAGER o LAZY según lo que prefieras
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersona")
    private Persona persona;

    private String especialidad;
    private String matricula;

    // Otros campos específicos de Medico
}
