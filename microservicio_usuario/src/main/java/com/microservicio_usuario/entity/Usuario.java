package com.microservicio_usuario.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String nombres;
    private String apellidos;
    @Column(unique = true)
    private String email;
    private String password;
    @Column(columnDefinition = "TIMESTAMP DEFAULT SYSTIMESTAMP")
    private Date fechaRegistro;
}
