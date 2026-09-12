package org.diagnoslab.pacientes.controller;

import jakarta.validation.Valid;
import org.diagnoslab.pacientes.models.entity.*;
import org.diagnoslab.pacientes.services.PacienteService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Paciente> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> detalle(@PathVariable Long id) {
        return service.porId(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Paciente p) {
        if (service.porDni(p.getDni()).isPresent())
            return ResponseEntity.badRequest().body(Map.of("mensaje", "El DNI ya está registrado"));
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(p));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @Valid @RequestBody Paciente cambio) {
        return service.porId(id).map(p -> {
            p.setDni(cambio.getDni());
            p.setNombres(cambio.getNombres());
            p.setEdad(cambio.getEdad());
            p.setSexo(cambio.getSexo());
            p.setTelefono(cambio.getTelefono());
            p.setCorreo(cambio.getCorreo());
            return ResponseEntity.ok(service.guardar(p));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (service.porId(id).isEmpty()) return ResponseEntity.notFound().build();
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{idPaciente}/ordenes")
    public ResponseEntity<OrdenAtencion> crearOrden(@PathVariable Long idPaciente, @Valid @RequestBody OrdenAtencion orden) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crearOrden(idPaciente, orden));
    }

    @GetMapping("/{idPaciente}/ordenes")
    public List<OrdenAtencion> listarOrdenes(@PathVariable Long idPaciente) {
        return service.listarOrdenes(idPaciente);
    }

    @GetMapping("/ordenes/{id}")
    public ResponseEntity<OrdenAtencion> detalleOrden(@PathVariable Long id) {
        return service.ordenPorId(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
