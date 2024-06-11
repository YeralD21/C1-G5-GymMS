package com.example.mspagoclase.feing;

import com.example.mspagoclase.dto.ClaseDto;
import com.example.mspagoclase.dto.ClientepagoclaseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-clase-service", path = "/clase")

public interface ClaseFeing {
    @GetMapping("/{id}")
    public ResponseEntity<ClaseDto> buscarPorId(@PathVariable(required = true)Integer id);
}