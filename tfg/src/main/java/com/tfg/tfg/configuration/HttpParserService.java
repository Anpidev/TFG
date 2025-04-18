package com.tfg.tfg.configuration;

import java.util.Date;

import org.springframework.security.core.Authentication;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HttpParserService {

    private long expiracion = 3600000; // esto es el tiempo de expiracion del token
	private String claveEncriptar = "superclavesuperclavesuperclavesuperclave";

	// que es la que se denomina portador nos identifica el portador
	private String prefijoToken = "Bearer";

	// la cabecera en donde vamos a ubicar el token que es la cabecera de
	// authorization
	private String cabeceraHttp = "Authorization";

    private TokenService tokenService;
    

    public void creaToken(HttpServletResponse response, String usuario) {

		String JWT = new TokenService().creaToken(usuario, claveEncriptar,
				new Date(System.currentTimeMillis() + expiracion));
        //generar una cabecera autenticacion
		response.addHeader(cabeceraHttp, prefijoToken + " " + JWT);

	}


    public Authentication leeToken(HttpServletRequest request) {

		tokenService= new TokenService();
		String token = request.getHeader(cabeceraHttp);
		System.out.println("token actual" + token);
		String tokenReal = null;
		if (token != null) {
			tokenReal = token.substring(token.indexOf(" ") + 1);

		}
		System.out.println("token Real " + tokenReal);
		if (token != null) {

			String usuario = tokenService.leeToken(tokenReal, claveEncriptar);
			System.out.println("el usuario es "+ usuario);
			if (usuario != null) {

				// hay q devolver un objeto ya de Spring framework concretamente de la parte de
				// seguridad
				// esto es ya una problematica de integracion
				// como lo gestionamos???
				return new UsuarioAutentificado(usuario);

			}

		}

		return null;

	}


}

