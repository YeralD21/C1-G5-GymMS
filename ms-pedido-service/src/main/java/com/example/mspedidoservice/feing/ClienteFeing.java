package com.example.mspedidoservice.feing;

import com.example.mspedidoservice.dto.ClienteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-clientegym-service", path = "/clientegym")
public interface ClienteFeing {
    @GetMapping("/{id}")
    ResponseEntity<ClienteDto> findById(@PathVariable(required = true) Integer id);
}
