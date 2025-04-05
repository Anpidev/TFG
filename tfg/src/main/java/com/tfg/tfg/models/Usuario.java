package com.tfg.tfg.models;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String dni;

	private String nombre;

	private String apellido;

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

	public Usuario(String dni,String nombre, String apellido) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Usuario( String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Usuario(String dni, String nombre, String apellido, Rol rol, String email, String usuario,
			String password) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
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

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.rol == null) {
            return List.of();
        }
        return List.of(new SimpleGrantedAuthority("ROLE_" + this.rol.name()));
    }


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return usuario;
	}

}
