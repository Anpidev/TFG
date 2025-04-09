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

import com.tfg.tfg.dto.AnaliticaDto;
import com.tfg.tfg.mappers.AnaliticaMapper;
import com.tfg.tfg.models.Analitica;
import com.tfg.tfg.services.AnaliticaService;

@RestController
@RequestMapping("/webapi/analiticas")
public class AnaliticaRestController {

	private AnaliticaService analiticaService;

	public AnaliticaRestController(AnaliticaService analiticaService) {
		super();
		this.analiticaService = analiticaService;

		
	}

	@CrossOrigin
	@GetMapping
	public List<AnaliticaDto> buscarTodasLasAnaliticas() {
		return analiticaService.findAllAnaliticas().stream().map(AnaliticaMapper::toDto).toList();
	}

	@CrossOrigin
	@PostMapping
	public AnaliticaDto salvarAnalitica(@RequestBody AnaliticaDto dto) {
		Analitica analitica = AnaliticaMapper.toEntity(dto);
		Analitica analiticaSalvada = analiticaService.saveAnalitica(analitica);
		return AnaliticaMapper.toDto(analiticaSalvada);

	}

	@CrossOrigin
	@DeleteMapping("/{id}")
	public void borrarAnalitica(@PathVariable int id) {
		analiticaService.deleteByIdAnalitica(id);
	}

	@CrossOrigin
	@PutMapping("/{id}")
	public AnaliticaDto actualizarAnalitica(@RequestBody AnaliticaDto dto, @PathVariable int id) {

		Optional<Analitica> Optionalanalitica = analiticaService.findByIdAnalitica(id);

		Analitica analiticaSalvada = null;
		if (Optionalanalitica.isPresent()) {
			Analitica analitica = Optionalanalitica.get();
			// SOLO SE PODRAN ACTUALIZAR EL ESTADO POR ENFERMERA
			analitica.setEstado(dto.getEstado());
			analiticaSalvada = analiticaService.saveAnalitica(analitica);

		}
		return AnaliticaMapper.toDto(analiticaSalvada);
	}

}
