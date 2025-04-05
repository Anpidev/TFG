package com.tfg.tfg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.tfg.tfg.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	UserDetails findByUsuario(String username);

}
