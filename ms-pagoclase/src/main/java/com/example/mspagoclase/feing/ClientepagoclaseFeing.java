package com.example.mspagoclase.feing;

import com.example.mspagoclase.dto.ClientepagoclaseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-clientegym-service", path = "/clientegym")

public interface ClientepagoclaseFeing {
    @GetMapping("/{id}")
    public ResponseEntity<ClientepagoclaseDto> buscarPorId(@PathVariable(required = true)Integer id);
}
