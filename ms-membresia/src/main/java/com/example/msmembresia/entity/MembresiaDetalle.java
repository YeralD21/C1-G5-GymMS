package com.example.msmembresia.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MembresiaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fechainicio;
    private String fechafin;
    private String tipomembresia;
    private String costo;

    public MembresiaDetalle() {
        this.fechainicio = "default start date";  // Example default value
        this.fechafin = "default end date";      // Example default value
        this.tipomembresia = "basic";            // Example default value
        this.costo = "0";                        // Example default value
    }
}
