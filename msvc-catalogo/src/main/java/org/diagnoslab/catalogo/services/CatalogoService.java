package org.diagnoslab.catalogo.services;

import org.diagnoslab.catalogo.models.entity.*;

import java.util.*;

public interface CatalogoService {
    List<TipoAnalisis> listar();

    Optional<TipoAnalisis> porId(Long id);

    TipoAnalisis guardar(TipoAnalisis tipo);

    void eliminar(Long id);

    Optional<Parametro> parametroPorId(Long id);
}
