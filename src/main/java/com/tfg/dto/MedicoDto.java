package com.tfg.dto;

public class MedicoDto {

	private int id;

	private String colegiado;

	private String nombre;

	private String apellido;

	private String email;
	
	private String telefono;

	public MedicoDto() {
		super();
	}

	public MedicoDto(int id, String colegiado, String nombre, String apellido, String email, String telefono) {
		super();
		this.id = id;
		this.colegiado = colegiado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono=telefono;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColegiado() {
		return colegiado;
	}

	public void setColegiado(String colegiado) {
		this.colegiado = colegiado;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
}
