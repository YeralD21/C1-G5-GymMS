package com.example.mspagomembresia.controller;

import com.example.mspagomembresia.entity.Pagomembresia;
import com.example.mspagomembresia.service.PagoMembresiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/pagomembresia")
public class PagomembresiaController {
    @Autowired
    private PagoMembresiaService pagoMembresiaService;

    @GetMapping
    public ResponseEntity<List<Pagomembresia>> listar(){
        return ResponseEntity.ok(pagoMembresiaService.listar());
    }

    @PostMapping
    public ResponseEntity<Pagomembresia> guardar(@RequestBody Pagomembresia pagomembresia){

        return  ResponseEntity.ok(pagoMembresiaService.guardar(pagomembresia));

    }
    @GetMapping("/{id}")
    public ResponseEntity<Pagomembresia> buscarPorId(@PathVariable(required = true) Integer id){
        return  ResponseEntity.ok(pagoMembresiaService.buscarPorId(id));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Pagomembresia> editar(@PathVariable(required = true)Integer id, @RequestBody Pagomembresia pagomembresia){
        return ResponseEntity.ok(pagoMembresiaService.editar(pagomembresia));
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable(required = true) Integer id){
        pagoMembresiaService.eliminar(id);
        return "Eliminacion Correcta";

    }
}
