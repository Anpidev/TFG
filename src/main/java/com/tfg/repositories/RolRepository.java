package com.tfg.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfg.models.Rol;
import com.tfg.models.Roles;
@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

	Optional<Rol> findByNombre(Roles nombre);

}
