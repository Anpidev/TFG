package com.tfg.dto;

import com.tfg.models.Roles;

public class NuevoUsuarioDto {
	
	

	public String nombreUsuario;
	public String password;
	public Roles rol;
	
	
	public NuevoUsuarioDto() {
		super();
	}


	public NuevoUsuarioDto(String nombreUsuario, String password) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.password = password;
	}


	public NuevoUsuarioDto(String nombreUsuario, String password, Roles rol) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.rol = rol;
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


	public Roles getRol() {
		return rol;
	}


	public void setRol(Roles rol) {
		this.rol = rol;
	}
	
	

}
