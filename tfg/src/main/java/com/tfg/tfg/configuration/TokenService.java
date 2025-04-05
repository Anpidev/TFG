package com.tfg.tfg.configuration;

import java.sql.Date;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class TokenService {
	
	//metodo que crea el token
	
	public String crearToken(String usuario, String claveEncriptar, Date expiracion) {
		SecretKey clave = Keys.hmacShaKeyFor(claveEncriptar.getBytes());
		String JWT = Jwts.builder()
				.setSubject(usuario)
				.setExpiration(expiracion)
				
				.signWith(clave,SignatureAlgorithm.HS256)
				.compact();
		return JWT;
	}
	
	public String leerToken(String tokenReal, String claveEncriptar) {
		SecretKey clave= Keys.hmacShaKeyFor(claveEncriptar.getBytes());
		
		JwtParser parseador = Jwts.parser()
                .verifyWith(clave)  // Reemplaza a setSigningKey()
                .build();
		
		Jws<Claims> token = parseador.parseClaimsJws(tokenReal);
		System.out.println(token.getBody().getSubject());
		
		return token.getBody().getSubject();
	}

}
