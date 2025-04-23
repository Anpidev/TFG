package com.tfg.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pacientes")
public class Paciente {
	

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;

		private String dni;

		private String nombre;

		private String apellido;


		private String email;
		
		private String telefono;

		
		// Constructores, getters y setters...
		public Paciente() {
			super();
		}


		public Paciente(int id) {
			super();
			this.id = id;
		}


		public Paciente(int id, String dni, String nombre, String apellido, String email, String telefono) {
			super();
			this.id = id;
			this.dni = dni;
			this.nombre = nombre;
			this.apellido = apellido;
			this.email = email;
			this.telefono = telefono;
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


		public String getTelefono() {
			return telefono;
		}


		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		
		
		

		
		
}
