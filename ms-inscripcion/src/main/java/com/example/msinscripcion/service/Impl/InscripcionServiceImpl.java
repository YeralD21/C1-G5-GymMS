package com.example.msinscripcion.service.Impl;

import com.example.msinscripcion.entity.Inscripcion;
import com.example.msinscripcion.repository.InscripcionRepository;
import com.example.msinscripcion.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscripcionServiceImpl implements InscripcionService {
    @Autowired
    private InscripcionRepository inscripcionRepository;
    @Override
    public List<Inscripcion> listar() {
        return inscripcionRepository.findAll();
    }

    @Override
    public Inscripcion guardar(Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }

    @Override
    public Inscripcion buscarPorId(Integer id) {
        return inscripcionRepository.findById(id).get();
    }

    @Override
    public Inscripcion editar(Inscripcion inscripcion) {return inscripcionRepository.save(inscripcion);}

    @Override
    public void eliminar(Integer id) {inscripcionRepository.deleteById(id);}
}
