package org.diagnoslab.catalogo.repositories;

import org.diagnoslab.catalogo.models.entity.TipoAnalisis;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TipoAnalisisRepository extends CrudRepository<TipoAnalisis, Long> {
    Optional<TipoAnalisis> findByNombre(String nombre);
}
