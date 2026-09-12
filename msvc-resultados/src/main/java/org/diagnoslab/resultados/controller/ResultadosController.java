package org.diagnoslab.resultados.controller;

import jakarta.validation.Valid;
import org.diagnoslab.resultados.models.entity.*;
import org.diagnoslab.resultados.services.ResultadosService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/resultados")
public class ResultadosController {
    private final ResultadosService service;

    public ResultadosController(ResultadosService service) {
        this.service = service;
    }

    @GetMapping("/muestras")
    public List<Muestra> listarMuestras() {
        return service.listarMuestras();
    }

    @PostMapping("/muestras")
    public ResponseEntity<Muestra> crearMuestra(@Valid @RequestBody Muestra m) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrarMuestra(m));
    }

    @PatchMapping("/muestras/{id}/estado")
    public ResponseEntity<Muestra> cambiarEstadoMuestra(@PathVariable Long id, @RequestParam String estado, @RequestParam(required = false) String motivo) {
        return ResponseEntity.ok(service.actualizarEstadoMuestra(id, estado, motivo));
    }

    @GetMapping("/registros")
    public List<RegistroResultado> listarRegistros() {
        return service.listarRegistros();
    }

    @GetMapping("/registros/{id}")
    public ResponseEntity<RegistroResultado> detalleRegistro(@PathVariable Long id) {
        return service.registroPorId(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/registros")
    public ResponseEntity<RegistroResultado> crearRegistro(@Valid @RequestBody RegistroResultado r) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrarResultado(r));
    }

    @PatchMapping("/registros/{id}/validar")
    public ResponseEntity<RegistroResultado> validar(@PathVariable Long id) {
        return ResponseEntity.ok(service.validarRegistro(id));
    }
}
