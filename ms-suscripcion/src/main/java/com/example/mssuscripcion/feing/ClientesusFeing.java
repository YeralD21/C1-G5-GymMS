package com.example.mssuscripcion.feing;

import com.example.mssuscripcion.dto.ClientesusDto;
import com.example.mssuscripcion.entity.Suscripcion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-clientegym-service", path = "/clientegym")

public interface ClientesusFeing {
    @GetMapping( "/{id}" )
    public ResponseEntity<ClientesusDto> buscarPorId(@PathVariable(required = true)Integer id);
}
