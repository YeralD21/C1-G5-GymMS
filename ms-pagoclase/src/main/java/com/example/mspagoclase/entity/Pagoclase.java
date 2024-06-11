package com.example.mspagoclase.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Pagoclase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date fechaPago;
    private Double monto;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Integer clientegymId;
    private Integer claseId;

}
