package com.example.mssuscripcion.feing;

import com.example.mssuscripcion.dto.ClientesusDto;
import com.example.mssuscripcion.dto.PrecioclaseplanDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-tiposuscripcion-service", path = "/precioclaseplan")

public interface PrecioclaseplanFeing {
    @GetMapping ( "/{id}" )
    public ResponseEntity<PrecioclaseplanDto> buscarPorId(@PathVariable(required = true)Integer id);
}
