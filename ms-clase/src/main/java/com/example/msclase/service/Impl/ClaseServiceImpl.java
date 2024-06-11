package com.example.msclase.service.Impl;

import com.example.msclase.entity.Clase;
import com.example.msclase.repository.ClaseRepository;
import com.example.msclase.service.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaseServiceImpl implements ClaseService {
    @Autowired
    private ClaseRepository claseRepository;
    @Override
    public List<Clase> listar() {
        return claseRepository.findAll();
    }

    @Override
    public Clase guardar(Clase clase) {
        return claseRepository.save(clase);
    }

    @Override
    public Clase buscarPorId(Integer id) {
        return claseRepository.findById(id).get();
    }

    @Override
    public Clase editar(Clase clase) {return claseRepository.save(clase);}

    @Override
    public void eliminar(Integer id) {
        claseRepository.deleteById(id);
    }
}

