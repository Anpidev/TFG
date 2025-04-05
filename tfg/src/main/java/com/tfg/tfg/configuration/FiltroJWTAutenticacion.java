package com.tfg.tfg.configuration;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class FiltroJWTAutenticacion extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//leemos el token
		Authentication authentication = new HttpParserService().leeToken((HttpServletRequest)request);
		
		//asignar token de autentificacion que acabamos de validar con el service httpparser
		System.out.println("Llega el filtro de authentication JWT");
		System.out.println(authentication);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(request, response);
	}

}
