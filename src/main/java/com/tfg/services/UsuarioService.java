package com.tfg.tfg.services;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tfg.tfg.models.Usuario;
import com.tfg.tfg.repositories.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {
	
	private UsuarioRepository usuarioRepository;
	

	public UsuarioService(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByNombreUsuario(nombreUsuario)
				.orElseThrow(() -> new UsernameNotFoundException ("Usuario no encontrado"));
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(usuario.getRol().getNombre().toString());
		
		return new org.springframework.security.core.userdetails.User(
				usuario.getNombreUsuario(), 
				usuario.getPassword(),
				Collections.singleton(authority));
	}
	
	public boolean existsByNombreUsuario(String nombreUsuario) {
		return usuarioRepository.existsByNombreUsuario(nombreUsuario);
	}


	public void saveUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	
	public Usuario findByNombreUsuario (String nombreUsuario) {
		return usuarioRepository.findByNombreUsuario(nombreUsuario)
				.orElseThrow(() -> new UsernameNotFoundException ("Usuario no encontrado"));
	}
	
	
	public Usuario getDetallesUsuario() {
		String nombreUsuario=SecurityContextHolder.getContext().getAuthentication().getName();
		return findByNombreUsuario(nombreUsuario);
	}
	
}
