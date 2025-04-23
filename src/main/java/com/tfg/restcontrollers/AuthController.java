package com.tfg.restcontrollers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.dto.ApiMessage;
import com.tfg.dto.LoginUserDto;
import com.tfg.dto.NuevoUsuarioDto;
import com.tfg.models.Usuario;
import com.tfg.services.AuthService;
import com.tfg.services.UsuarioService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;



@RestController
@RequestMapping("webapi/auth")
public class AuthController {

    private final AuthService authService;
    private final UsuarioService usuarioService;

    

    public AuthController(AuthService authService, UsuarioService usuarioService) {
		super();
		this.authService = authService;
		this.usuarioService = usuarioService;
	}
    @CrossOrigin
	@PostMapping("/login")
    public ResponseEntity<ApiMessage> login(@Valid @RequestBody LoginUserDto loginUserDto, BindingResult bindingResult, HttpServletResponse response){
        if (bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(new ApiMessage("Revise sus credenciales"));
        }
        try {
            String roleName = authService.authenticate(loginUserDto.getNombreUsuario(), loginUserDto.getPassword(), response);
            return ResponseEntity.ok(new ApiMessage(roleName));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(new ApiMessage(e.getMessage()));
        }
    }
    @CrossOrigin
    @PostMapping("/register")
    public ResponseEntity<ApiMessage> register(@Valid @RequestBody NuevoUsuarioDto newUserDto, BindingResult bindingResult, HttpServletResponse response){
        if (bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(new ApiMessage("Revise los campos"));
        }
        try {
            // Registrar el nuevo usuario
            authService.registrarUsuario(newUserDto);
            
            // Autenticar automáticamente después de registrar
            String roleName = authService.authenticate(newUserDto.getNombreUsuario(), newUserDto.getPassword(),response);
            
            // Retornar el JWT como respuesta
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiMessage(roleName));
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(new ApiMessage(e.getMessage()));
        }
    }
    @CrossOrigin
    @GetMapping("/check-auth")
    public ResponseEntity<String> checkAuth(){
            return ResponseEntity.ok().body("Autenticado");
    }

    @CrossOrigin
    @GetMapping("/usuario/detalles")
    public ResponseEntity<Usuario> getAuthenticatedUser(){
         Usuario usuario = usuarioService.getDetallesUsuario();
         return ResponseEntity.ok(usuario);
         
    }

    @CrossOrigin
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletResponse response){
        authService.logout(response);
        return ResponseEntity.ok(new ApiMessage("Sesioón finalizada"));
    }
}