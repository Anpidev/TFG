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

public class FiltroJWTAutenticacion  extends GenericFilterBean{
    

    @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// asumimos que recibimos un token , que es nuestro token jwt con el usuario que necesitamos
		  Authentication authentication = new HttpParserService().leeToken((HttpServletRequest)request);
		
		  //asigna token de autenticacion que acabamos de validar con el servicio httpparser
		  System.out.println("llega al filtro de authenticacion JWT");
		  System.out.println(authentication);
		  SecurityContextHolder.getContext().setAuthentication(authentication);
		  chain.doFilter(request,response);
		
		
	}

}
