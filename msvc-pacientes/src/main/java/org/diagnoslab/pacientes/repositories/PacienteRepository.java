package org.diagnoslab.pacientes.repositories;

import org.diagnoslab.pacientes.models.entity.Paciente;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PacienteRepository extends CrudRepository<Paciente, Long> {
    Optional<Paciente> findByDni(String dni);
}
