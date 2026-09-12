package org.diagnoslab.catalogo.services;

import org.diagnoslab.catalogo.models.entity.*;
import org.diagnoslab.catalogo.repositories.TipoAnalisisRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class CatalogoServiceImpl implements CatalogoService {
    private final TipoAnalisisRepository repository;

    public CatalogoServiceImpl(TipoAnalisisRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<TipoAnalisis> listar() {
        return (List<TipoAnalisis>) repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<TipoAnalisis> porId(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public TipoAnalisis guardar(TipoAnalisis tipo) {
        return repository.save(tipo);
    }

    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Parametro> parametroPorId(Long id) {
        return listar().stream().flatMap(t -> t.getParametros().stream()).filter(p -> p.getId().equals(id)).findFirst();
    }
}
