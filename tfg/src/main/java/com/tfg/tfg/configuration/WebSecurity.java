package com.tfg.tfg.configuration;

import java.util.Arrays;

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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSecurity {

	// el sistema cryptografico que codifica
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() {

		// crear en memoria una base de datos de usuarios con un usuario para la
		// seguridad de la aplicacion
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(
				User.withUsername("angela").password(passwordEncoder().encode("miclave")).roles("ADMIN").build());
		return manager;

	}

	@Bean
	public AuthenticationManager authManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder,
			UserDetailsService userDetailsService) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class).userDetailsService(userDetailsService)
				.passwordEncoder(bCryptPasswordEncoder).and().build();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager manager) throws Exception {

		// desabilitar csrf
		//habilitar una url de login
		http
		.cors((cors) -> cors
				.configurationSource(corsConfigurationSource()))
		.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth -> auth.requestMatchers("/webapi/login").permitAll()
				//asegurarnos que el resto esta autenticado
				.anyRequest().authenticated())
				//deshabilitar la gestion de sessiones
				.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				//dar de alta dos filtros
				//el primero nos autentifica
				// y el segundo nos valida una vez que tenemos un token
				.addFilterBefore(new FiltroLogin("/webapi/login", manager),  UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(new FiltroJWTAutenticacion(), UsernamePasswordAuthenticationFilter.class);
				
		return http.build();

	}


	@Bean
	CorsConfigurationSource corsConfigurationSource() {
	    CorsConfiguration configuration = new CorsConfiguration();
	    configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200")); // Solo tu dominio Angular
	    configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
	    configuration.setAllowedHeaders(Arrays.asList("*"));
	    configuration.setExposedHeaders(Arrays.asList("Authorization")); // Crucial para exponer el header
	    configuration.setAllowCredentials(true); // Importante para cookies/tokens
	    configuration.setMaxAge(3600L); // Cache de preflight requests
	    
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", configuration);
	    return source;
	}

}
