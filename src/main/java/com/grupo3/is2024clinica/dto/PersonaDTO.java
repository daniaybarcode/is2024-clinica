// src/main/java/com/grupo3/is2024clinica/dto/PersonaDTO.java
package com.grupo3.is2024clinica.dto;

import com.grupo3.is2024clinica.model.Persona;

public class PersonaDTO {

    private Long cuil;
    private String nombre;
    private String apellido;
    private String domicilio;  // Nueva propiedad
    private String telefono;    // Nueva propiedad
    private String email;       // Nueva propiedad
    private String fechaDeNacimiento; // Nueva propiedad

    // Constructor que transforma la entidad Persona en un DTO
    public PersonaDTO(Persona persona) {
        this.cuil = (persona.getCuil() != null) ? persona.getCuil() : 0L; // Manejo de null
        this.nombre = persona.getNombre();
        this.apellido = persona.getApellido();
        this.domicilio = persona.getDomicilio();   // Manejo de domicilio
        this.telefono = persona.getTelefono();     // Manejo de telefono
        this.email = persona.getEmail();           // Manejo de email
        this.fechaDeNacimiento = persona.getFechaDeNacimiento(); // Manejo de fechaDeNacimiento
    }

    // Getters y setters
    public Long getCuil() {
        return cuil;
    }

    public void setCuil(Long cuil) {
        this.cuil = cuil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
}
