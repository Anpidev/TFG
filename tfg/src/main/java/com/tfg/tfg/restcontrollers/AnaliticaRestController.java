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
import com.tfg.tfg.dto.UsuarioDto;
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
		
		
		//REST ANALITICA
	}
	@CrossOrigin	@GetMapping
	public List<AnaliticaDto> buscarTodasLasAnaliticas() {
		return analiticaService.findAllAnaliticas().stream().map(AnaliticaMapper::toDto).toList();
	}

	@PostMapping
	public AnaliticaDto salvarAnalitica(@RequestBody AnaliticaDto dto) {
		Analitica analitica = AnaliticaMapper.toEntity(dto);
		Analitica analiticaSalvada = analiticaService.saveAnalitica(analitica);
		return AnaliticaMapper.toDto(analiticaSalvada);

	}
	@DeleteMapping("/{id}")
	public void borrarAnalitica(@PathVariable int id){
		analiticaService.deleteByIdAnalitica(id);
	}

	
	@PutMapping("/{id}")
	public AnaliticaDto actualizarAnalitica(@RequestBody AnaliticaDto dto, @PathVariable int id) {
		
		Optional<Analitica> Optionalanalitica = analiticaService.findByIdAnalitica(id);
		
		Analitica analiticaSalvada =null;
		if (Optionalanalitica.isPresent()) {
			Analitica analitica = Optionalanalitica.get();
			//SOLO SE PODRAN ACTUALIZAR ESTOS DATOS
			analitica.setFechaCreacion(dto.getFechaCreacion());
			analitica.setEstado(dto.getEstado());
			analitica.setObservaciones(dto.getObservaciones());
			analitica.setParametros(dto.getParametros());
			analiticaSalvada = analiticaService.saveAnalitica(analitica);
		
		}
		return AnaliticaMapper.toDto(analiticaSalvada);
	}
	
//REST USUARIOS
		
	@CrossOrigin	@GetMapping("/usuarios")
	public List<UsuarioDto> buscarTodosLosUsuarios() {
		return analiticaService.findAllUsuarios();
	}
}
