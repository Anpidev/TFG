package com.tfg.tfg.restcontrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.tfg.dto.MedicoDto;
import com.tfg.tfg.mappers.MedicoMapper;
import com.tfg.tfg.models.Medico;
import com.tfg.tfg.services.AnaliticaService;

@RestController
@RequestMapping("/webapi/medicos")
public class MedicoRestController {

	private AnaliticaService analiticaService;

	public MedicoRestController(AnaliticaService analiticaService) {
		super();
		this.analiticaService = analiticaService;

	}
	
	@CrossOrigin
	@GetMapping
	public List<MedicoDto> buscarTodosLsMedicoDtos() {
		return analiticaService.findAllMedicos().stream().map(MedicoMapper::toDto).toList();
	}

	@CrossOrigin
	@PostMapping
	public MedicoDto salvarMedico(@RequestBody MedicoDto dto) {
		Medico medico = MedicoMapper.toEntity(dto);
		Medico medicoSalvado = analiticaService.saveMedico(medico);
		return MedicoMapper.toDto(medicoSalvado);

	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	public void borrarMedico(@PathVariable int id) {
		analiticaService.deleteByMedico(id);
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	public MedicoDto actualizarMedico(@RequestBody MedicoDto dto, @PathVariable int id) {

		Optional<Medico> Optionalmedico = analiticaService.findByIdMedico(id);

		Medico medicoSalvado = null;
		if (Optionalmedico.isPresent()) {
			Medico medico = Optionalmedico.get();

			medico.setColegiado(dto.getColegiado());
			medico.setNombre(dto.getNombre());
			medico.setApellido(dto.getApellido());
			medico.setEmail(dto.getEmail());
			medico.setTelefono(dto.getTelefono());

			medicoSalvado = analiticaService.saveMedico(medico);

		}
		return MedicoMapper.toDto(medicoSalvado);
	}
}