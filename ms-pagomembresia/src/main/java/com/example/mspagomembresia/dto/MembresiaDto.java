package com.example.mspagomembresia.dto;

import lombok.Data;

@Data
public class MembresiaDto {
    private Integer id;
    private String fechainicio;
    private String fechafin;
    private String tipomembresia;
    private String costo;
    private ClientegymDto clientegymDto;

}
