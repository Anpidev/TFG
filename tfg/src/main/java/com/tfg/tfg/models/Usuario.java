package com.tfg.tfg.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Enumerated(EnumType.STRING)
	@Column(name = "rol")
	private Rol rol;

	private String email;

	private String usuario;

	private String password;

	// Constructores, getters y setters...

	public Usuario() {
		super();
	}

	public Usuario(int id) {
		super();
		this.id = id;
	}

	public Usuario(Rol rol, String email, String usuario, String password) {
		super();
		this.rol = rol;
		this.email = email;
		this.usuario = usuario;
		this.password = password;
	}

	// Enumerado para los tipos
	public enum Rol {
		PACIENTE, ENFERMERA, MEDICO, ADMIN
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
