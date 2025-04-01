package com.tfg.tfg.mappers;

import com.tfg.tfg.dto.AnaliticaDto;
import com.tfg.tfg.models.Analitica;
import com.tfg.tfg.models.Usuario;

public class AnaliticaMapper {

	public static Analitica toEntity(AnaliticaDto dto) {
		Usuario paciente = new Usuario();
		Usuario medico = new Usuario();
		paciente.setId(dto.getPacienteId());
		paciente.setNombre(dto.getPacienteNombre());
		paciente.setApellido(dto.getPacienteApellido());
		paciente.setDni(dto.getPacienteDni());
		medico.setId(dto.getMedicoId());
		medico.setNombre(dto.getMedicoNombre());
		medico.setApellido(dto.getMedicoApellido());
		
		

		Analitica analitica = new Analitica(dto.getId(), paciente, medico, dto.getFechaCreacion(),dto.getEstado(),
				dto.getObservaciones(),dto.getParametros() );
		return analitica;
	}

	public static AnaliticaDto toDto(Analitica analitica) {

		Usuario paciente = analitica.getPaciente();
		Usuario medico = analitica.getMedico();

		AnaliticaDto dto = new AnaliticaDto(analitica.getId(), paciente.getId(), paciente.getNombre(),
				paciente.getApellido(), paciente.getDni(), medico.getId(), medico.getNombre(), medico.getApellido(),
				analitica.getFechaCreacion(), analitica.getEstado(), analitica.getObservaciones(),
				analitica.getParametros());

		return dto;
	}

}