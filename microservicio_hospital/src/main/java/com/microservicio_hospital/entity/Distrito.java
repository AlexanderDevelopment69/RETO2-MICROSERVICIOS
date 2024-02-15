package com.microservicio_hospital.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table(name = "Distrito")
public class Distrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_distrito")
    private Long idDistrito;

    @Column(name = "desc_distrito")
    private String descDistrito;

    @Column(name = "fecha_registro",columnDefinition = "TIMESTAMP DEFAULT SYSTIMESTAMP")
    private Date fechaRegistro;


}