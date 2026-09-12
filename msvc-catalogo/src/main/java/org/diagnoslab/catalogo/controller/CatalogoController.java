package org.diagnoslab.catalogo.controller;

import jakarta.validation.Valid;
import org.diagnoslab.catalogo.models.entity.*;
import org.diagnoslab.catalogo.services.CatalogoService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/catalogo")
public class CatalogoController {
    private final CatalogoService service;

    public CatalogoController(CatalogoService service) {
        this.service = service;
    }

    @GetMapping("/tipos-analisis")
    public List<TipoAnalisis> listar() {
        return service.listar();
    }

    @GetMapping("/tipos-analisis/{id}")
    public ResponseEntity<TipoAnalisis> detalle(@PathVariable Long id) {
        return service.porId(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/tipos-analisis")
    public ResponseEntity<TipoAnalisis> crear(@Valid @RequestBody TipoAnalisis tipo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(tipo));
    }

    @PutMapping("/tipos-analisis/{id}")
    public ResponseEntity<TipoAnalisis> editar(@PathVariable Long id, @Valid @RequestBody TipoAnalisis cambio) {
        return service.porId(id).map(t -> {
            t.setNombre(cambio.getNombre());
            t.setAreaAnalisis(cambio.getAreaAnalisis());
            t.setEstado(cambio.getEstado());
            t.setParametros(cambio.getParametros());
            return ResponseEntity.ok(service.guardar(t));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/tipos-analisis/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (service.porId(id).isEmpty()) return ResponseEntity.notFound().build();
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/parametros/{id}")
    public ResponseEntity<Parametro> detalleParametro(@PathVariable Long id) {
        return service.parametroPorId(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
