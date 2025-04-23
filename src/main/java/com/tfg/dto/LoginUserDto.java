package com.tfg.dto;



public class LoginUserDto {
	
	public String nombreUsuario;
	public String password;
	
	
	public LoginUserDto() {
		super();
	}


	public LoginUserDto(String nombreUsuario, String password) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.password = password;
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
	
	
	

}
