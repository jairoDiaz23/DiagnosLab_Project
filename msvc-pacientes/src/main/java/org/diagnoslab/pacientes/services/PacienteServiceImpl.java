package org.diagnoslab.pacientes.services;

import org.diagnoslab.pacientes.clients.CatalogoClientRest;
import org.diagnoslab.pacientes.models.entity.*;
import org.diagnoslab.pacientes.repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class PacienteServiceImpl implements PacienteService {
    private final PacienteRepository pacientes;
    private final OrdenAtencionRepository ordenes;
    private final CatalogoClientRest catalogo;

    public PacienteServiceImpl(PacienteRepository pacientes, OrdenAtencionRepository ordenes, CatalogoClientRest catalogo) {
        this.pacientes = pacientes;
        this.ordenes = ordenes;
        this.catalogo = catalogo;
    }

    @Transactional(readOnly = true)
    public List<Paciente> listar() {
        return (List<Paciente>) pacientes.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Paciente> porId(Long id) {
        return pacientes.findById(id);
    }

    @Transactional
    public Paciente guardar(Paciente p) {
        return pacientes.save(p);
    }

    @Transactional
    public void eliminar(Long id) {
        pacientes.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Paciente> porDni(String dni) {
        return pacientes.findByDni(dni);
    }

    @Transactional
    public OrdenAtencion crearOrden(Long pacienteId, OrdenAtencion orden) {
        if (!pacientes.existsById(pacienteId)) throw new NoSuchElementException("El paciente no existe");
        orden.setPacienteId(pacienteId);
        for (ExamenSolicitado examen : orden.getExamenes()) {
            catalogo.obtenerTipoAnalisis(examen.getTipoAnalisisId());
            examen.setRegistradoEnCatalogo(true);
        }
        return ordenes.save(orden);
    }

    @Transactional(readOnly = true)
    public List<OrdenAtencion> listarOrdenes(Long pacienteId) {
        return ordenes.findByPacienteId(pacienteId);
    }

    @Transactional(readOnly = true)
    public Optional<OrdenAtencion> ordenPorId(Long id) {
        return ordenes.findById(id);
    }
}
