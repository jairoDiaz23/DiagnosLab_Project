package org.diagnoslab.pacientes.services;

import org.diagnoslab.pacientes.models.entity.*;

import java.util.*;

public interface PacienteService {
    List<Paciente> listar();

    Optional<Paciente> porId(Long id);

    Paciente guardar(Paciente paciente);

    void eliminar(Long id);

    Optional<Paciente> porDni(String dni);

    OrdenAtencion crearOrden(Long pacienteId, OrdenAtencion orden);

    List<OrdenAtencion> listarOrdenes(Long pacienteId);

    Optional<OrdenAtencion> ordenPorId(Long id);
}
