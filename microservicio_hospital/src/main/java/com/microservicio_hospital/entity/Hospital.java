package com.microservicio_hospital.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table(name = "Hospital")
public class Hospital {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHospital")
    private Long idHospital;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "antiguedad")
    private Integer antiguedad;

    @Column(name = "area")
    private Double area;

    @Column(name = "fecha_registro",columnDefinition = "TIMESTAMP DEFAULT SYSTIMESTAMP")
    private Date fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "id_distrito")
    private Distrito distrito;

    @ManyToOne
    @JoinColumn(name = "id_sede")
    private Sede sede;

    @ManyToOne
    @JoinColumn(name = "id_gerente")
    private Gerente gerente;

    @ManyToOne
    @JoinColumn(name = "id_condicion")
    private Condicion condicion;


}