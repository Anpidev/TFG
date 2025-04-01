package com.tfg.tfg.restcontrollers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	
	@GetMapping
	public List<AnaliticaDto> findAllAnaliticas() {
		return analiticaService.findAllAnaliticas().stream().map(AnaliticaMapper::toDto).toList();
	}
	
	@PostMapping
	public AnaliticaDto salvarAnalitica(@RequestBody AnaliticaDto dto ) {
		Analitica analitica = AnaliticaMapper.toEntity(dto);
		Analitica analiticaSalvada= analiticaService.saveAnalitica(analitica);
		return AnaliticaMapper.toDto(analiticaSalvada);
		
		
	}

}
