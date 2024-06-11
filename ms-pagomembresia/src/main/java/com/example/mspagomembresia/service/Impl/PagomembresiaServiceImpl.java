package com.example.mspagomembresia.service.Impl;

import com.example.mspagomembresia.dto.ClientegymDto;
import com.example.mspagomembresia.dto.MembresiaDto;
import com.example.mspagomembresia.entity.Pagomembresia;
import com.example.mspagomembresia.repository.PagomembresiaRepository;
import com.example.mspagomembresia.service.PagoMembresiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagomembresiaServiceImpl implements PagoMembresiaService {
    @Autowired
private PagomembresiaRepository pagomembresiaRepository;
    @Autowired
    private ClientegymDto clientegymDto;
    @Autowired
    private MembresiaDto membresiaDto;
    @Override
    public List<Pagomembresia> listar() {
        return pagomembresiaRepository.findAll();
    }

    @Override
    public Pagomembresia guardar(Pagomembresia pagomembresia) {
        return pagomembresiaRepository.save(pagomembresia);
    }

    @Override
    public Pagomembresia buscarPorId(Integer id) {
        return pagomembresiaRepository.findById(id).get();
    }

    @Override
    public Pagomembresia editar(Pagomembresia pagomembresia) {
        return pagomembresiaRepository.save(pagomembresia);
    }

    @Override
    public void eliminar(Integer id) {
        pagomembresiaRepository.deleteById(id);
    }

}
