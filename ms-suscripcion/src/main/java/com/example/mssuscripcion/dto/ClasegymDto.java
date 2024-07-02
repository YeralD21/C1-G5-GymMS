package com.example.mssuscripcion.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class ClasegymDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Tipoclase; //zumba, X-Box, baile, musculación
    private Integer cuposDisponibles;

    private PlanDto plan;

}
