package com.microservicio_hospital.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table(name = "Gerente")
public class Gerente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gerente")
    private Long idGerente;

    @Column(name = "desc_gerente")
    private String descGerente;

    @Column(name = "fecha_registro",columnDefinition = "TIMESTAMP DEFAULT SYSTIMESTAMP")
    private Date fechaRegistro;

}
