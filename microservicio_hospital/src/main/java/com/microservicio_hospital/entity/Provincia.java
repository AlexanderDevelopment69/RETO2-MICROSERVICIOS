package com.microservicio_hospital.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Provincia")
public class Provincia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_provincia")
    private Long idProvincia;

    @Column(name = "desc_provincia")
    private String descProvincia;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;


}