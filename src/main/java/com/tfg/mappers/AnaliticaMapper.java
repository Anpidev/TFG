package com.tfg.tfg.mappers;

import com.tfg.tfg.dto.AnaliticaDto;
import com.tfg.tfg.models.Analitica;
import com.tfg.tfg.models.Medico;
import com.tfg.tfg.models.Paciente;

public class AnaliticaMapper {

	public static Analitica toEntity(AnaliticaDto dto) {
		Paciente paciente = new Paciente();
		Medico medico = new Medico();
		paciente.setId(dto.getPacienteId());
		paciente.setNombre(dto.getPacienteNombre());
		paciente.setApellido(dto.getPacienteApellido());
		paciente.setDni(dto.getPacienteDni());
		medico.setId(dto.getMedicoId());
		medico.setNombre(dto.getMedicoNombre());
		medico.setApellido(dto.getMedicoApellido());
		medico.setColegiado(dto.getMedicoColegiado());

		Analitica analitica = new Analitica(dto.getId(), paciente, medico, dto.getFechaCreacion(), dto.getEstado(),
				dto.getObservaciones(), dto.getParametros());
		return analitica;
	}

	public static AnaliticaDto toDto(Analitica analitica) {

		Paciente paciente = analitica.getPaciente();
		Medico medico = analitica.getMedico();

		AnaliticaDto dto = new AnaliticaDto(analitica.getId(), paciente.getId(), paciente.getNombre(),
				paciente.getApellido(), paciente.getDni(), medico.getId(), medico.getNombre(), medico.getApellido(),medico.getColegiado(),
				analitica.getFechaCreacion(), analitica.getEstado(), analitica.getObservaciones(),
				analitica.getParametros());

		return dto;
	}

}