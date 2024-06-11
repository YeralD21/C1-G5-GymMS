package com.example.msasesoramiento.service.Impl.Impl;

import com.example.msasesoramiento.entity.Asesoramiento;
import com.example.msasesoramiento.repository.AsesoramientoRepository;
import com.example.msasesoramiento.service.Impl.AsesoramientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsesoramientoServiceImpl implements AsesoramientoService {
    @Autowired
    private AsesoramientoRepository asesoramientoRepository;

    @Override
    public List<Asesoramiento> listar() {
        return asesoramientoRepository.findAll();
    }

    @Override
    public Asesoramiento guardar(Asesoramiento asesoramiento) {
        return asesoramientoRepository.save(asesoramiento);
    }

    @Override
    public Asesoramiento buscarPorId(Integer id) {
        return asesoramientoRepository.findById(id).get();
    }

    @Override
    public Asesoramiento editar(Asesoramiento asesoramiento) {
        return asesoramientoRepository.save(asesoramiento);
    }

    @Override
    public void eliminar(Integer id) {
        asesoramientoRepository.deleteById(id);
    }

}
