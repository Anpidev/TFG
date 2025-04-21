package com.tfg.tfg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tfg.tfg.models.Analitica;
@Repository
public interface AnaliticaRepository extends JpaRepository<Analitica, Integer>{
	
	 @Query("SELECT DISTINCT a FROM Analitica a " +
	           "LEFT JOIN FETCH a.paciente " +
	           "LEFT JOIN FETCH a.medico " +
	           "LEFT JOIN FETCH a.parametros")
	    List<Analitica> findAllWithRelations();
	}


