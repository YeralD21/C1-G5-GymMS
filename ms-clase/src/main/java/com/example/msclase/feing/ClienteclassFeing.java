package com.example.msclase.feing;

import com.example.msclase.dto.ClienteclassDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-clientegym-service", path = "/clientegym")

public interface ClienteclassFeing {
    @GetMapping("/{id}")
    public ResponseEntity<ClienteclassDto> buscarPorId(@PathVariable(required = true)Integer id);
}
