package com.example.mssuscripcion.dto;

import lombok.Data;

@Data

public class PrecioclaseplanDto {
    private Integer id;
    private Double precio;

    private PlanDto planDto;

    private ClasegymDto clasegymDto;

}
