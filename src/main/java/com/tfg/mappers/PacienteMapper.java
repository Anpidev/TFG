package com.tfg.tfg.mappers;

import com.tfg.tfg.dto.PacienteDto;
import com.tfg.tfg.models.Paciente;

public class PacienteMapper {

	public static Paciente toEntity(PacienteDto dto) {
		

		Paciente paciente = new Paciente(dto.getId(),dto.getDni(),dto.getNombre(),dto.getApellido(),dto.getEmail(),dto.getTelefono());
		return paciente;
	}

	public static PacienteDto toDto(Paciente paciente) {

	

		PacienteDto dto = new PacienteDto(paciente.getId(),paciente.getDni(),paciente.getNombre(),paciente.getApellido(),paciente.getEmail(),paciente.getTelefono());

		return dto;
	}

	
	
}
