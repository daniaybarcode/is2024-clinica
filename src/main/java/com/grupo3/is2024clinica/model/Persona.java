// src/main/java/com/grupo3/is2024clinica/model/Persona.java
package com.grupo3.is2024clinica.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersona")
    private Long idPersona;

    private Long cuil;
    private String nombre;
    private String apellido;
    private String domicilio;
    private String telefono;
    private String email;
    private String fechaDeNacimiento;

}
