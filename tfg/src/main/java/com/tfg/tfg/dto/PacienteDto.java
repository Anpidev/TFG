package com.tfg.tfg.dto;

public class PacienteDto {

	private int id;

	private String dni;

	private String nombre;

	private String apellido;

	private String email;

	public PacienteDto() {
		super();
	}

	public PacienteDto(int id, String dni, String nombre, String apellido, String email) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;

		this.email = email;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
