package com.grupo3.is2024clinica.dto;

import com.grupo3.is2024clinica.model.EvolucionClinica;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class EvolucionClinicaDTO {

    private Integer idEvolucionClinica;
    private String textoLibre;
    private LocalDateTime fechaYhora;
    private Long idMedico;
    private Integer idDiagnostico;

    // Constructor para convertir desde el modelo EvolucionClinica a EvolucionClinicaDTO
    public EvolucionClinicaDTO(EvolucionClinica evolucionClinica) {
        this.idEvolucionClinica = evolucionClinica.getIdEvolucionClinica();
        this.textoLibre = evolucionClinica.getTextoLibre();
        this.fechaYhora = evolucionClinica.getFechaYhora();
        this.idMedico = evolucionClinica.getMedico().getIdMedico();
        this.idDiagnostico = evolucionClinica.getDiagnostico().getIdDiagnostico();
    }
}
