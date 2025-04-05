package com.tfg.tfg.configuration;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

@SuppressWarnings("serial")
public class UsuarioAutentificado implements Authentication {
	// Autentificar usuario

	private String name;
	private boolean authenticated = true;

	// informacion de la que dispongo en el token

	public UsuarioAutentificado(String name) {
		super();
		this.name = name;

	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAuthenticated() {
		return authenticated;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		this.authenticated = isAuthenticated;

	}
}