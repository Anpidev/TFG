package com.tfg.tfg.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurity {

	//Encriptacion de claves
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean 
	public UserDetailsService userDetailsService() {
		
		//Crear en memoria una base de datos de usuarios con un usuario para la seguridad de la aplicacion
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
				manager.createUser(User.withUsername("angela")
					.password(passwordEncoder().encode("miclave"))
					.roles("ADMIN")
					.build());
				return manager;
				
	}
	
	//Parte de autentificar
	@Bean
	public AuthenticationManager authManager (HttpSecurity http, BCryptPasswordEncoder passwordEncoder,
			UserDetailsService userDetailsService)throws Exception{
		
		//Usa http para leerdatos, crypt paa encriptar y userdetail para obtener los usuarios
		return http.getSharedObject(AuthenticationManagerBuilder.class).userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder).and().build();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager manager)throws Exception {
		
		//deshabilitar csrf
		//habilitar url de login
	
		http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth -> auth.requestMatchers("/webapi/login").permitAll()
				//asegurarnos que el resto esta autenticado
				.anyRequest().authenticated())
				//deshabilitar la gestion de sesiones
				.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				//dar de alta dos filtros: el primero autentifica el segundo valida el token
				.addFilterBefore(new FiltroLogin ("/webapi/login",manager),UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(new FiltroJWTAutenticacion(), UsernamePasswordAuthenticationFilter.class);
				
				return http.build();
		
	}
}