package com.example.msinscripcion.feing;

import com.example.msinscripcion.dto.ClaseinscripcionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "ms-clase-service", path = "/clase")

public interface ClaseinscripcionFeing {
    @GetMapping("/{id}")
    public ResponseEntity<ClaseinscripcionDto> buscarPorId(@PathVariable(required = true)Integer id);
}
