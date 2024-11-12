package com.grupo3.is2024clinica.dto;

import com.grupo3.is2024clinica.model.Persona;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PersonaDTO {
    private Long idPersona;
    private Long cuil;
    private String nombre;
    private String apellido;
    private String domicilio;
    private String telefono;
    private String email;
    private LocalDate fechaDeNacimiento; // Cambiado a LocalDate para consistencia con la fecha

    // Constructor que transforma la entidad Persona en un DTO
    public PersonaDTO(Persona persona) {
        this.idPersona = persona.getIdPersona();
        this.cuil = persona.getCuil() != null ? persona.getCuil() : 0L; // Manejo de null
        this.nombre = persona.getNombre();
        this.apellido = persona.getApellido();
        this.domicilio = persona.getDomicilio();
        this.telefono = persona.getTelefono();
        this.email = persona.getEmail();
        this.fechaDeNacimiento = LocalDate.parse(persona.getFechaDeNacimiento()); // Asumiendo que es LocalDate en la entidad
    }
}
