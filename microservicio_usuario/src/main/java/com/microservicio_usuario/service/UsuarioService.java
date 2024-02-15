package com.microservicio_usuario.service;

import com.microservicio_usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void registrarUsuario(String nombres, String apellidos, String email, String password) {
        usuarioRepository.registrarUsuario(nombres, apellidos, email, password);
    }




    public Long iniciarSesion(String email, String password) {
        return usuarioRepository.iniciarSesion(email, password);
    }

}
