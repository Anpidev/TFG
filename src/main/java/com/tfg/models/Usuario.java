package com.tfg.tfg.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	@Column(unique = true, nullable = false)
	private String nombreUsuario;

	@JsonIgnore
	@NotBlank
	@Column( nullable = false)
	private String password;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "rol_id", nullable = false)
	private Rol rol;

	
	//CONSTRUCTORES
	
	public Usuario() {
		super();
	}


	public Usuario(Integer id, @NotBlank String nombreUsuario, @NotBlank String password, Rol rol) {
		super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.rol = rol;
	}
	
	

	
	public Usuario(@NotBlank String nombreUsuario, @NotBlank String password, Rol rol) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.rol = rol;
	}


	//GETTER Y SETTERS

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombreUsuario() {
		return nombreUsuario;
	}


	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Rol getRol() {
		return rol;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}

	
}
