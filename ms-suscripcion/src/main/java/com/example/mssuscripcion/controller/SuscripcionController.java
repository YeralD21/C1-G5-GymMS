package com.example.mssuscripcion.controller;

import com.example.mssuscripcion.entity.Suscripcion;
import com.example.mssuscripcion.service.SuscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suscripcion")
public class SuscripcionController {
    @Autowired
    private SuscripcionService suscripcionService;
    @GetMapping
    public ResponseEntity<List<Suscripcion>> listar(){
        return ResponseEntity.ok(suscripcionService.listar());
    }

    @PostMapping
    public ResponseEntity<Suscripcion> guardar(@RequestBody Suscripcion suscripcion){

        return  ResponseEntity.ok(suscripcionService.guardar(suscripcion));

    }
    @GetMapping("/{id}")
    public ResponseEntity<Suscripcion> buscarPorId(@PathVariable(required = true) Integer id){
        return  ResponseEntity.ok(suscripcionService.buscarPorId(id));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Suscripcion> editar(@PathVariable(required = true)Integer id,@RequestBody Suscripcion suscripcion){
        return ResponseEntity.ok(suscripcionService.editar(suscripcion));
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable(required = true) Integer id){
        suscripcionService.eliminar(id);
        return "Eliminacion Correcta";

    }
}
