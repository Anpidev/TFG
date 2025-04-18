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

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FiltroLogin extends AbstractAuthenticationProcessingFilter {
  
    private HttpParserService httpParserService;
  
  
   
    public FiltroLogin(String url ,AuthenticationManager manager) {
		
		super(new AntPathRequestMatcher(url));
		System.out.println("el manager es "+manager);
		httpParserService= new HttpParserService();
		setAuthenticationManager(manager);
		
	}


    @Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		
                //formato json
				Usuario usuario = new ObjectMapper().readValue(request.getInputStream(),Usuario.class);
				System.out.println(usuario.getUsuario());
				System.out.println(usuario.getPassword());
				
				UsernamePasswordAuthenticationToken usuarioSpring = new UsernamePasswordAuthenticationToken(usuario.getUsuario(), usuario.getPassword());
				System.out.println("es valido"+getAuthenticationManager().authenticate(usuarioSpring).getPrincipal());
				return getAuthenticationManager().authenticate(usuarioSpring);
	}


	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
				String nombreUsuario= authResult.getName();
				System.out.println("autentificacion valida" + nombreUsuario);
				httpParserService.creaToken(response, nombreUsuario);
	}


}
