package com.tfg.tfg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tfg.tfg.models.Analitica;
import com.tfg.tfg.models.Usuario;
import com.tfg.tfg.repositories.AnaliticaRepository;
import com.tfg.tfg.repositories.UsuarioRepository;

@Service
public class AnaliticaService {
	
	
	//Inyección de dependencias a traves de constructores
	
	private UsuarioRepository usuarioRepository;
	private AnaliticaRepository analiticaRepository;
	
	public AnaliticaService(UsuarioRepository usuarioRepository,
			AnaliticaRepository analiticaRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
		this.analiticaRepository = analiticaRepository;
	}

	
	//Metodos de analitica
	public <S extends Analitica> S saveAnalitica(S analitica) {
		return analiticaRepository.save(analitica);
	}

	public List<Analitica> findAllAnaliticas() {
		return analiticaRepository.findAllWithRelations();
	}

	public Optional<Analitica> findByIdAnalitica(Integer id) {
		return analiticaRepository.findById(id);
	}

	public void deleteByIdAnalitica(int id) {
		analiticaRepository.deleteById(id);
	}


	
	
	//Metodos de usuario
	public <S extends Usuario> S saveUsuario(S usuario) {
		return usuarioRepository.save(usuario);
	}


	public List<Usuario> findAllUsuarios() {
		return usuarioRepository.findAll();
	}


	public Optional<Usuario> findByIdUsuario(Integer id) {
		return usuarioRepository.findById(id);
	}


	public void deleteByIdUsuario(int id) {
		usuarioRepository.deleteById(id);
	}


	
	
	

}
