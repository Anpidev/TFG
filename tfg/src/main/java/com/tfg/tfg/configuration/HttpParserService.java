package com.tfg.tfg.configuration;

import java.sql.Date;

import org.springframework.security.core.Authentication;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HttpParserService {

	//tiempo de expiracion del token una hora
	private long expiracion=3600000;
	
	//clave para encriptar
	
	private String claveEncriptar="superclavesuperclavesuperclavesuperclave";
	
	//portador
	
	private String prefijoToken ="Bearer";
	
	//cabecera donde vamos a ubicar el token (cabecera de authorization)
	private String cabeceraHttp ="Authorization";
	
	private TokenService tokenService;
	
	public void creaToken(HttpServletResponse response, String usuario) {
		
		String JWT = new TokenService().crearToken(usuario, claveEncriptar, new Date(System.currentTimeMillis()+expiracion));
		//generar cabecera autentificacion
		response.addHeader(cabeceraHttp, prefijoToken + " " + JWT);
	}
	
	
	public Authentication leeToken (HttpServletRequest request) {
		
		tokenService= new TokenService();
		String token = request.getHeader(cabeceraHttp);
		System.out.println("token actual "+token);
		String tokenReal = null;
		if (token!=null) {
			tokenReal=token.substring(token.indexOf(" ")+1);
		}
		System.out.println("token real "+tokenReal);
		if (token!=null) {
			
			String usuario = tokenService.leerToken(tokenReal, claveEncriptar);
			System.out.println("el usuario es "+usuario);
			if (usuario!=null) {
				/*Hay que devolver un objeto ya de Spring framework, de seguridad,
				 * ¿Como se gestiona?
				 */
				return new UsuarioAutentificado(usuario);
			}
			
		}
		return null;
	}
	
}
