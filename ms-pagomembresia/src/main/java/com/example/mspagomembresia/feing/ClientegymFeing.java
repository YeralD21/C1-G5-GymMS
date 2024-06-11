package com.example.mspagomembresia.feing;

import com.example.mspagomembresia.dto.ClientegymDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-clientegym-service", path = "/clientegym")
public interface ClientegymFeing {
    @GetMapping("/{id}")
    public ResponseEntity<ClientegymDto> buscarPorId(@PathVariable(required = true)Integer id);

}
