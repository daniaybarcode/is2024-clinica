package com.grupo3.is2024clinica.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MedicoDTO {
    private Long idMedico;
    private String matricula;
    private String especialidad;
    private PersonaDTO persona; // Contiene los detalles de la persona asociada al médico
}
