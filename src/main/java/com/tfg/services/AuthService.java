package com.tfg.tfg.services;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tfg.tfg.dto.NuevoUsuarioDto;
import com.tfg.tfg.jwt.JwtUtil;
import com.tfg.tfg.models.Rol;
import com.tfg.tfg.models.Usuario;
import com.tfg.tfg.repositories.RolRepository;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class AuthService {

    private final UsuarioService userService;
    private final RolRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final CookieService cookieService;

   

    public AuthService(UsuarioService userService, RolRepository roleRepository, PasswordEncoder passwordEncoder,
			JwtUtil jwtUtil, AuthenticationManagerBuilder authenticationManagerBuilder, CookieService cookieService) {
		super();
		this.userService = userService;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtUtil = jwtUtil;
		this.authenticationManagerBuilder = authenticationManagerBuilder;
		this.cookieService = cookieService;
	}

	public String authenticate(String username, String password, HttpServletResponse response){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);
        Authentication authResult = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authResult);
        String jwt=jwtUtil.crearToken(authResult);
        cookieService.addHttpOnlyCookie("jwt", jwt, 7*24*60*60, response);
        Usuario usuario= userService.findByNombreUsuario(username);
        return usuario.getRol().getNombre().toString();
    }

    public void registrarUsuario(NuevoUsuarioDto nuevoUsuarioDto) {
        if (userService.existsByNombreUsuario(nuevoUsuarioDto.getNombreUsuario())) {
            throw new IllegalArgumentException("El nombre de usuario ya existe");
        }

        Rol rolUsuario = roleRepository.findByNombre(nuevoUsuarioDto.getRol())
            .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        Usuario usuario = new Usuario(
            nuevoUsuarioDto.getNombreUsuario(),
            passwordEncoder.encode(nuevoUsuarioDto.getPassword()),
            rolUsuario
        );

        userService.saveUsuario(usuario);
    }

    public void  logout(HttpServletResponse response){
        cookieService.deleteCookie("jwt", response);
    }
}