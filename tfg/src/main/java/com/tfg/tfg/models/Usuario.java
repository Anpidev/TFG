package com.tfg.tfg.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "dni", unique = true, nullable = false)
	private String dni;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "apellido", nullable = false) // Añadido campo faltante
	private String apellido;

	@Column(name = "tipo", nullable = false)
	private String tipo;

	@Column(name = "email", unique = true, nullable = false)
	private String email;

	@Column(name = "usuario", unique = true, nullable = false)
	private String usuario;

	@Column(name = "password", nullable = false)
	private String password;

	// Constructores, getters y setters...

	public Usuario() {
		super();
	}

	public Usuario(int id) {
		super();
		this.id = id;
	}

	public Usuario(String dni, String nombre, String apellido, String email) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}

	public Usuario(String dni, String nombre, String apellido, String tipo, String email, String usuario,
			String password) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipo = tipo;
		this.email = email;
		this.usuario = usuario;
		this.password = password;
	}

	// Enumerado para los tipos
	public enum Tipo {
		PACIENTE, ENFERMERA, MEDICO, ADMIN
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

	public String getTipo() {
		return tipo;
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
