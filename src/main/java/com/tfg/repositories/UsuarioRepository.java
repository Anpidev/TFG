package com.tfg.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfg.models.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	

	Optional<Usuario> findByNombreUsuario(String nombreUsuario);
	
	boolean existsByNombreUsuario(String nombreUsuario);

}
