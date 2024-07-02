package com.example.mssuscripcion.feing;

import com.example.mssuscripcion.dto.ClasegymDto;
import com.example.mssuscripcion.entity.Suscripcion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-tiposuscripcion-service", path = "/clasegym")
public interface ClasegymFeing {
    @GetMapping( "/{id}" )
    public ResponseEntity<ClasegymDto> buscarPorId(@PathVariable(required = true)Integer id);
}
