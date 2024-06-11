package com.example.msasesoramiento.entity;

import jakarta.persistence.*;
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
