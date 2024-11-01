package com.grupo3.is2024clinica.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PacienteDTO {
    private Long idPaciente;
    private String nombrePersona; // Suponiendo que deseas el nombre de la persona
    private String pasaporte;
    private String estado;
    private LocalDate fechaDeFallecimiento;

    // Constructor adicional si necesitas inicializar con la entidad
    public PacienteDTO(Long idPaciente, String nombrePersona, String pasaporte, String estado, LocalDate fechaDeFallecimiento) {
        this.idPaciente = idPaciente;
        this.nombrePersona = nombrePersona;
        this.pasaporte = pasaporte;
        this.estado = estado;
        this.fechaDeFallecimiento = fechaDeFallecimiento;
    }
}
