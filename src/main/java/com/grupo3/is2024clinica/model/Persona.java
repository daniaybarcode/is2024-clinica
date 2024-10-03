// src/main/java/com/grupo3/is2024clinica/model/Persona.java
package com.grupo3.is2024clinica.model;

import jakarta.persistence.*;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersona")
    private Long idPersona;

    private Long cuil;
    private String nombre;
    private String apellido;
    private String domicilio;  // Nueva propiedad
    private String telefono;    // Nueva propiedad
    private String email;       // Nueva propiedad
    private String fechaDeNacimiento; // Nueva propiedad (puede ser LocalDate)

    // Getters y setters
    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long id) {
        this.idPersona = id;
    }

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
