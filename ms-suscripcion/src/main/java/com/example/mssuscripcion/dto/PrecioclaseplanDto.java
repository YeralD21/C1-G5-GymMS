package com.example.mssuscripcion.dto;

import lombok.Data;

@Data

public class PrecioclaseplanDto {
        private Integer id;
        private Double precio;
        private PlanDto plan;
        private ClasegymDto clasegymDto;

    public PlanDto getPlan() {
        return plan;
    }

    public void setPlan(PlanDto plan) {
        this.plan = plan;
    }

    public ClasegymDto getClasegymDto() {
        return clasegymDto;
    }

    public void setClasegymDto(ClasegymDto clasegymDto) {
        this.clasegymDto = clasegymDto;
    }
    }