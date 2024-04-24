package com.example.msmembresia.entity;

import com.example.msmembresia.dto.ClientegymDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Membresia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fechainicio;
    private String fechafin;
    private String tipomembresia;
    private String costo;
    private Integer clientegymId;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "venta_id")
    private List<MembresiaDetalle>detalles;

    @Transient
    ClientegymDto clientegymDto;

}
