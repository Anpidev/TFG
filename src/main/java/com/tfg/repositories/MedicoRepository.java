package com.tfg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfg.models.Medico;
@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer>{

}
