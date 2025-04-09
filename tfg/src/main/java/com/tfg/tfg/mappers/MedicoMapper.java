package com.tfg.tfg.mappers;

import com.tfg.tfg.dto.MedicoDto;
import com.tfg.tfg.models.Medico;

public class MedicoMapper {

	public static Medico toEntity(MedicoDto dto) {

		Medico medico = new Medico(dto.getId(), dto.getColegiado(), dto.getNombre(), dto.getApellido(), dto.getEmail(),
				dto.getTelefono());
		return medico;
	}

	public static MedicoDto toDto(Medico medico) {

		MedicoDto dto = new MedicoDto(medico.getId(), medico.getColegiado(), medico.getNombre(), medico.getApellido(),
				medico.getEmail(), medico.getTelefono());

		return dto;
	}

}
