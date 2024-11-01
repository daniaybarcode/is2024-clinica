package com.grupo3.is2024clinica.dto;

import java.time.LocalDate;

public class HistoriaClinicaDTO {

    private Integer idHistoriaClinica; // Cambiar Long por Integer
    private String descripcion;
    private LocalDate fechaCreado; // Cambiar fechaConsulta por fechaCreado
    private Integer idPaciente; // Cambiar Long por Integer

    public Integer getIdHistoriaClinica() {
        return idHistoriaClinica; // Cambiar getId por getIdHistoriaClinica
    }

    public void setIdHistoriaClinica(Integer idHistoriaClinica) {
        this.idHistoriaClinica = idHistoriaClinica; // Cambiar setId por setIdHistoriaClinica
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaCreado() {
        return fechaCreado; // Cambiar getFechaConsulta por getFechaCreado
    }

    public void setFechaCreado(LocalDate fechaCreado) {
        this.fechaCreado = fechaCreado; // Cambiar setFechaConsulta por setFechaCreado
    }

    public Integer getIdPaciente() {
        return idPaciente; // Cambiar getIdPersona por getIdPaciente
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente; // Cambiar setIdPersona por setIdPaciente
    }
}
