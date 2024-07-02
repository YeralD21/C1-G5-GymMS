package com.example.mssuscripcion.service.Impl;

import com.example.mssuscripcion.entity.Suscripcion;
import com.example.mssuscripcion.feing.ClasegymFeing;
import com.example.mssuscripcion.feing.ClientesusFeing;
import com.example.mssuscripcion.feing.PrecioclaseplanFeing;
import com.example.mssuscripcion.repository.SuscripcionRepository;
import com.example.mssuscripcion.service.SuscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuscripcionServiceImpl implements SuscripcionService {
    @Autowired
    private SuscripcionRepository suscripcionRepository;

    @Autowired
    private ClientesusFeing clientesusFeing;

    @Autowired
    private ClasegymFeing clasegymFeing;

    @Autowired
    private PrecioclaseplanFeing precioclaseplanFeing;

    @Override
    public List<Suscripcion> listar() {
        return suscripcionRepository.findAll();
    }

    @Override
    public Suscripcion guardar(Suscripcion suscripcion) {
        return suscripcionRepository.save(suscripcion);
    }

    @Override
    public Suscripcion buscarPorId(Integer id) {
        Suscripcion suscripcion = suscripcionRepository.findById(id).get();
        suscripcion.setClientesusDto(clientesusFeing.buscarPorId(suscripcion.getClientegymId()).getBody());

        suscripcion.setClasegymDto(clasegymFeing.buscarPorId(suscripcion.getClasegymId()).getBody());
        suscripcion.setPrecioclaseplanDto(precioclaseplanFeing.buscarPorId(suscripcion.getprecioclaseplanId()).getBody());


        return suscripcion;
}

    @Override
    public Suscripcion editar(Suscripcion suscripcion) {
        return suscripcionRepository.save(suscripcion);
    }

    @Override
    public void eliminar(Integer id) {
        suscripcionRepository.deleteById(id);
    }
}
