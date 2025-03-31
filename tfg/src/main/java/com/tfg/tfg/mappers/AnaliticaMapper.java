package com.tfg.tfg.mappers;

import com.tfg.tfg.dto.AnaliticaDto;
import com.tfg.tfg.models.Analitica;
import com.tfg.tfg.models.Parametro;

public class AnaliticaMapper {
    public static AnaliticaDto toDto(Analitica analitica) {
        AnaliticaDto dto = new AnaliticaDto();
        dto.setId(analitica.getId());
        
        // Nombres completos directamente
        if(analitica.getPaciente() != null) {
            dto.setPacienteNombre(analitica.getPaciente().getNombre() + " " + 
                                 analitica.getPaciente().getApellido());
        }
        
        if(analitica.getMedico() != null) {
            dto.setMedicoNombre(analitica.getMedico().getNombre() + " " + 
                               analitica.getMedico().getApellido());
        }
        
        dto.setFechaCreacion(analitica.getFechaCreacion());
        dto.setEstado(analitica.getEstado());
        dto.setObservaciones(analitica.getObservaciones());
        
        // Solo los nombres de los parámetros
        if(analitica.getParametros() != null) {
            dto.setParametros(
                analitica.getParametros().stream()
                    .map(Parametro::getNombre)
                    .toList()
            );
        }
        
        return dto;
    }
}