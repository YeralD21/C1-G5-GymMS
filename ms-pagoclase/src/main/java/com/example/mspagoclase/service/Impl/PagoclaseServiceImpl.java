package com.example.mspagoclase.service.Impl;

import com.example.mspagoclase.entity.Pagoclase;
import com.example.mspagoclase.repository.PagoclaseRepository;
import com.example.mspagoclase.service.PagoclaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoclaseServiceImpl implements PagoclaseService {
    @Autowired
    private PagoclaseRepository pagoclaseRepository;
    @Override
    public List<Pagoclase> listar() {
        return pagoclaseRepository.findAll();
    }

    @Override
    public Pagoclase guardar(Pagoclase pagoclase) {
        return pagoclaseRepository.save(pagoclase);
    }

    @Override
    public Pagoclase buscarPorId(Integer id) {
        return pagoclaseRepository.findById(id).get();
    }

    @Override
    public Pagoclase editar(Pagoclase pagoclase) {return pagoclaseRepository.save(pagoclase);}

    @Override
    public void eliminar(Integer id) {
        pagoclaseRepository.deleteById(id);
    }
}

