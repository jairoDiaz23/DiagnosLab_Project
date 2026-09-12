package org.diagnoslab.pacientes.repositories;

import org.diagnoslab.pacientes.models.entity.OrdenAtencion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdenAtencionRepository extends CrudRepository<OrdenAtencion, Long> {
    List<OrdenAtencion> findByPacienteId(Long pacienteId);
}
