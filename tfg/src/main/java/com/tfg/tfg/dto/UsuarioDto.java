package com.tfg.tfg.dto;

import com.tfg.tfg.models.Usuario.Rol;

public class UsuarioDto {

	
	private int id;

	private String dni;

	private String nombre;

	private String apellido;

	private Rol rol;

	private String email;

	private String usuario;

	private String password;

	public UsuarioDto() {
		super();
	}

	public UsuarioDto(int id, String dni, String nombre, String apellido, Rol rol, String email, String usuario,
			String password) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rol = rol;
		this.email = email;
		this.usuario = usuario;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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
