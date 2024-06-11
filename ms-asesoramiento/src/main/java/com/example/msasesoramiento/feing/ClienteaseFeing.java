package com.example.msasesoramiento.feing;

import com.example.msasesoramiento.dto.ClienteaseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-clientegym-service", path = "/clientegym")

public interface ClienteaseFeing {
    @GetMapping("/{id}")
    public ResponseEntity<ClienteaseDto> buscarPorId(@PathVariable(required = true)Integer id);

}
