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

import com.tfg.tfg.dto.PacienteDto;
import com.tfg.tfg.mappers.PacienteMapper;
import com.tfg.tfg.models.Paciente;
import com.tfg.tfg.services.AnaliticaService;

@RestController
@RequestMapping("/webapi/pacientes")
public class PacienteRestController {

	private AnaliticaService analiticaService;

	public PacienteRestController(AnaliticaService analiticaService) {
		super();
		this.analiticaService = analiticaService;

	}
	
	@CrossOrigin
	@GetMapping
	public List<PacienteDto> buscarTodasLosPacienteDtos() {
		return analiticaService.findAllPacientes().stream().map(PacienteMapper::toDto).toList();
	}
	
	@CrossOrigin
	@PostMapping
	public PacienteDto salvarPaciente(@RequestBody PacienteDto dto) {
		Paciente paciente = PacienteMapper.toEntity(dto);
		Paciente pacienteSalvado = analiticaService.savePaciente(paciente);
		return PacienteMapper.toDto(pacienteSalvado);

	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	public void borrarPaciente(@PathVariable int id) {
		analiticaService.deleteByIdPaciente(id);
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	public PacienteDto actualizarPaciente(@RequestBody PacienteDto dto, @PathVariable int id) {

		Optional<Paciente> Optionalpaciente = analiticaService.findByIdPaciente(id);

		Paciente pacienteSalvado = null;
		if (Optionalpaciente.isPresent()) {
			Paciente paciente = Optionalpaciente.get();

			paciente.setDni(dto.getDni());
			paciente.setNombre(dto.getNombre());
			paciente.setApellido(dto.getApellido());
			paciente.setEmail(dto.getEmail());
			paciente.setTelefono(dto.getTelefono());

			pacienteSalvado = analiticaService.savePaciente(paciente);

		}
		return PacienteMapper.toDto(pacienteSalvado);
	}
}