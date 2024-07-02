package com.example.mssuscripcion.service.Impl;

import com.example.mssuscripcion.dto.ClasegymDto;
import com.example.mssuscripcion.dto.ClientesusDto;
import com.example.mssuscripcion.dto.PlanDto;
import com.example.mssuscripcion.dto.PrecioclaseplanDto;
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
        // Obtener datos del cliente
        ClientesusDto clienteDto = clientesusFeing.buscarPorId(suscripcion.getClientegymId()).getBody();
        suscripcion.setClientesusDto(clienteDto);

        // Obtener datos de ClaseGym
        ClasegymDto clasegymDto = clasegymFeing.buscarPorId(suscripcion.getClasegymId()).getBody();
        if (clasegymDto != null) {
            PlanDto planDto = clasegymDto.getPlan(); // Obtener el plan del ClasegymDto
            clasegymDto.setPlan(planDto); // Asignar el plan al ClasegymDto
            suscripcion.setClasegymDto(clasegymDto);
        }

        // Obtener datos de PrecioClasePlan
        PrecioclaseplanDto precioclaseplanDto = precioclaseplanFeing.buscarPorId(suscripcion.getPrecioclaseplanId()).getBody();
        precioclaseplanDto.setClasegym(clasegymDto); // Asignar Clasegym al PrecioClasePlan
        precioclaseplanDto.setPlan(clasegymDto.getPlan()); // Asignar Plan al PrecioClasePlan
        suscripcion.setPrecioclaseplanDto(precioclaseplanDto);

        return suscripcionRepository.save(suscripcion);
    }
    @Override
    public Suscripcion buscarPorId(Integer id) {
        Suscripcion suscripcion = suscripcionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Suscripción no encontrada"));

        // Obtener datos del cliente
        ClientesusDto clienteDto = clientesusFeing.buscarPorId(suscripcion.getClientegymId()).getBody();
        suscripcion.setClientesusDto(clienteDto);

        // Obtener datos de ClaseGym
        ClasegymDto clasegymDto = clasegymFeing.buscarPorId(suscripcion.getClasegymId()).getBody();
        if (clasegymDto != null) {
            PlanDto planDto = clasegymDto.getPlan(); // Asegúrate de que el plan esté siendo asignado
            clasegymDto.setPlan(planDto);
            suscripcion.setClasegymDto(clasegymDto);
        }

        // Obtener datos de PrecioClasePlan
        PrecioclaseplanDto precioclaseplanDto = precioclaseplanFeing.buscarPorId(suscripcion.getPrecioclaseplanId()).getBody();
        suscripcion.setPrecioclaseplanDto(precioclaseplanDto);

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
