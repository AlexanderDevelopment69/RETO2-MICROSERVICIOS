package com.microservicio_hospital.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table(name = "Sede")
public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sede")
    private Long idSede;

    @Column(name = "desc_sede")
    private String descSede;

    @Column(name = "fecha_registro",columnDefinition = "TIMESTAMP DEFAULT SYSTIMESTAMP")
    private Date fechaRegistro;
}