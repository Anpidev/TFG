package com.tfg.tfg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfg.tfg.models.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer>{

}
