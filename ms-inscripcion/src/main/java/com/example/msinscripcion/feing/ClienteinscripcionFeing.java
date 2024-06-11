package com.example.msinscripcion.feing;

import com.example.msinscripcion.dto.ClienteinscripcionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-clientegym-service", path = "/clientegym")

public interface ClienteinscripcionFeing {
    @GetMapping("/{id}")
    public ResponseEntity<ClienteinscripcionDto> buscarPorId(@PathVariable(required = true)Integer id);
}
