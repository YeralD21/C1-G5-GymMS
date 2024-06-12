package com.example.mspagomembresia.service.Impl;

import com.example.mspagomembresia.dto.ClientegymDto;
import com.example.mspagomembresia.dto.MembresiaDto;
import com.example.mspagomembresia.entity.Pagomembresia;
import com.example.mspagomembresia.feing.ClientegymFeing;
import com.example.mspagomembresia.feing.MembresiaFeing;
import com.example.mspagomembresia.repository.PagomembresiaRepository;
import com.example.mspagomembresia.service.PagoMembresiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PagomembresiaServiceImpl implements PagoMembresiaService {
    @Autowired
private PagomembresiaRepository pagomembresiaRepository;
    @Autowired
    private ClientegymFeing clientegymFeing;
    @Autowired
    private MembresiaFeing membresiaFeing;
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
        Pagomembresia pagomembresia = pagomembresiaRepository.findById(id).get();
        pagomembresia.setClientegymDto(clientegymFeing.buscarPorId(pagomembresia.getClientegymId()).getBody());
        pagomembresia.setMembresiaDto(membresiaFeing.buscarPorId(pagomembresia.getMembresiaId()).getBody());
        return pagomembresia;
    }
    @Override
    public Pagomembresia editar(Pagomembresia pagomembresia) {
        return pagomembresiaRepository.save(pagomembresia);
    }

    @Override
    public void eliminar(Integer id) {
        pagomembresiaRepository.deleteById(id);
    }

    @Override
    public void procesarPago(BigDecimal montoConIGV) {
        // Implementa la lógica para procesar el pago con el monto que incluye IGV
        System.out.println("Procesando pago con IGV: " + montoConIGV);
        // Aquí iría la lógica de negocio real, como guardar el pago en la base de datos
    }

}
