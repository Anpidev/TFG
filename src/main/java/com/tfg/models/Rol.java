package com.tfg.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING) 
	private Roles nombre;

	// CONSTRUCTORES

	public Rol() {
		super();
	}

	public Rol(int id, Roles nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

//GETTER Y SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Roles getNombre() {
		return nombre;
	}

	public void setNombre(Roles nombre) {
		this.nombre = nombre;
	}

}
