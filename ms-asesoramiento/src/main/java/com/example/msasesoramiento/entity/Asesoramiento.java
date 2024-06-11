package com.example.msasesoramiento.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class Asesoramiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String tipoMembresia;
    private String objetivo;
    private String planAlimentacion;
    private String rutina;
    private Date fechaInicio;
    private Date fechaFin;

    private Integer clientegymId;
    private Integer trainerId;

}
