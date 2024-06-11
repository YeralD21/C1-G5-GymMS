package com.example.msasesoramiento.feing;

import com.example.msasesoramiento.dto.TrainerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-trainer-service", path = "/trainer")

public interface TrainerFeing {
    @GetMapping("/{id}")
    public ResponseEntity<TrainerDto> buscarPorId(@PathVariable(required = true)Integer id);

}
