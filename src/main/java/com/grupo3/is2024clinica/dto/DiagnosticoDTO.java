package com.grupo3.is2024clinica.dto;

import com.grupo3.is2024clinica.model.Diagnostico;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DiagnosticoDTO {

    private Integer idDiagnostico;
    private String enfermedad;
    private String observaciones;
    private Long idHistoriaClinica;

    // Constructor para convertir desde el modelo Diagnostico a DiagnosticoDTO
    public DiagnosticoDTO(Diagnostico diagnostico) {
        this.idDiagnostico = diagnostico.getIdDiagnostico();
        this.enfermedad = diagnostico.getEnfermedad();
        this.observaciones = diagnostico.getObservaciones();
        this.idHistoriaClinica = diagnostico.getHistoriaClinica().getIdHistoriaClinica();
    }
}
