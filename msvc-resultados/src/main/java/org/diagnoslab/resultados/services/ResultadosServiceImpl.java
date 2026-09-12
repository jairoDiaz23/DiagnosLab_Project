package org.diagnoslab.resultados.services;

import org.diagnoslab.resultados.clients.*;
import org.diagnoslab.resultados.models.entity.*;
import org.diagnoslab.resultados.repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ResultadosServiceImpl implements ResultadosService {
    private final MuestraRepository muestras;
    private final RegistroResultadoRepository registros;
    private final PacientesClientRest pacientes;
    private final CatalogoClientRest catalogo;

    public ResultadosServiceImpl(MuestraRepository muestras, RegistroResultadoRepository registros, PacientesClientRest pacientes, CatalogoClientRest catalogo) {
        this.muestras = muestras;
        this.registros = registros;
        this.pacientes = pacientes;
        this.catalogo = catalogo;
    }

    @Transactional(readOnly = true)
    public List<Muestra> listarMuestras() {
        return (List<Muestra>) muestras.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Muestra> muestraPorId(Long id) {
        return muestras.findById(id);
    }

    @Transactional
    public Muestra registrarMuestra(Muestra m) {
        pacientes.obtenerOrden(m.getOrdenAtencionId());
        return muestras.save(m);
    }

    @Transactional
    public Muestra actualizarEstadoMuestra(Long id, String estado, String motivo) {
        Muestra m = muestras.findById(id).orElseThrow(() -> new NoSuchElementException("Muestra no encontrada"));
        m.setEstado(estado);
        m.setCondicionRechazo(motivo);
        return muestras.save(m);
    }

    @Transactional(readOnly = true)
    public List<RegistroResultado> listarRegistros() {
        return (List<RegistroResultado>) registros.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<RegistroResultado> registroPorId(Long id) {
        return registros.findById(id);
    }

    @Transactional
    public RegistroResultado registrarResultado(RegistroResultado r) {
        pacientes.obtenerOrden(r.getOrdenAtencionId());
        Muestra muestra = muestras.findById(r.getMuestraId()).orElseThrow(() -> new NoSuchElementException("Muestra no encontrada"));
        if (!muestra.getOrdenAtencionId().equals(r.getOrdenAtencionId()))
            throw new IllegalArgumentException("La muestra no pertenece a la orden indicada");
        for (ValorResultado v : r.getValores()) catalogo.obtenerParametro(v.getParametroId());
        return registros.save(r);
    }

    @Transactional
    public RegistroResultado validarRegistro(Long id) {
        RegistroResultado r = registros.findById(id).orElseThrow(() -> new NoSuchElementException("Registro no encontrado"));
        r.setEstadoValidacion("VALIDADO");
        r.setFechaValidacion(LocalDateTime.now());
        return registros.save(r);
    }
}
