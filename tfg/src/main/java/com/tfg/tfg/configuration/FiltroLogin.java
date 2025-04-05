package com.tfg.tfg.configuration;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tfg.tfg.models.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FiltroLogin extends AbstractAuthenticationProcessingFilter{
	
	private HttpParserService httpParserService;

	protected FiltroLogin(String url, AuthenticationManager manager) {
		super(new AntPathRequestMatcher(url));
		System.out.println("el manager es "+manager);
		httpParserService = new HttpParserService();
		setAuthenticationManager(manager);
	}

	//Para comprobar si el usuario existe y si tiene credenciales validas
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		
		//formato JSON
		Usuario usuario= new ObjectMapper().readValue(request.getInputStream(),Usuario.class);
		System.out.println(usuario.getUsuario());
		System.out.println(usuario.getPassword());

		
		UsernamePasswordAuthenticationToken usuarioSpring = new UsernamePasswordAuthenticationToken(usuario.getUsuario(),usuario.getPassword());
		System.out.println("es válido "+getAuthenticationManager().authenticate(usuarioSpring));
		
				return getAuthenticationManager().authenticate(usuarioSpring);
	}
	
	
	//Usuario valido, se crea token JWT
	
	protected void successfulAuthentication(HttpServletRequest request,HttpServletResponse response,
			Authentication authResult) throws IOException, ServletException{
		
		String nombreUsuario = authResult.getName();
		System.out.println("Autentificación válida "+nombreUsuario);
		httpParserService.creaToken(response, nombreUsuario);
	}

}
