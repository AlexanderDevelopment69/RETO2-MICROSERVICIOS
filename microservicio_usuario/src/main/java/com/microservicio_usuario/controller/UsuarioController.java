package com.microservicio_usuario.controller;

import com.microservicio_usuario.entity.Usuario;
import com.microservicio_usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarUsuario(@RequestBody Usuario usuario) {
        try {
            usuarioRepository.registrarUsuario(usuario.getNombres(), usuario.getApellidos(),
                    usuario.getEmail(), usuario.getPassword());
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado correctamente.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Los datos del usuario son inválidos.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar el usuario.");
        }
    }

    @PostMapping("/iniciar-sesion")
    public ResponseEntity<String> iniciarSesion(@RequestBody Usuario usuario) {
        try {
            Long idUsuario = usuarioRepository.iniciarSesion(usuario.getEmail(), usuario.getPassword());
            if (idUsuario != null) {
                return ResponseEntity.ok("Inicio de sesión exitoso. ID de usuario: " + idUsuario);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al iniciar sesión.");
        }
    }
}
