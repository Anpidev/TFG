package com.tfg.tfg.configuration;

import java.util.Date;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class TokenService {
    
    // este  es el metodo que crea el token
    public String creaToken(String usuario,String claveEncriptar,Date expiracion) {
		
		SecretKey clave=Keys.hmacShaKeyFor(claveEncriptar.getBytes());
		
		String JWT = Jwts.builder()
		         .setSubject(usuario)
		         .setExpiration(expiracion)
				 
				 .signWith(clave,SignatureAlgorithm.HS256)
		         //es la parte en la cual nosotros definimos la clave de encriptacion y el algoritmo para generar el has
		         .compact();
			
			return JWT;
		
	}

    //nosotros leamos el token obtendremos el usuario
	public String leeToken(String tokenReal, String claveEncriptar) {
		
		

		SecretKey clave=Keys.hmacShaKeyFor(claveEncriptar.getBytes());
	

			JwtParser parseador = Jwts.parserBuilder().setSigningKey(clave).build();
			Jws<Claims> token=parseador.parseClaimsJws(tokenReal);
			System.out.println(token.getBody().getSubject());
		return token.getBody().getSubject();
	}
	

}
