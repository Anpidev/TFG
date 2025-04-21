package com.tfg.tfg.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfg.tfg.models.Rol;
import com.tfg.tfg.models.Roles;
@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

	Optional<Rol> findByNombre(Roles nombre);

}
