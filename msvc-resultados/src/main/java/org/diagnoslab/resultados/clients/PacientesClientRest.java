package org.diagnoslab.resultados.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "msvc-pacientes", url = "http://localhost:8081/api/pacientes")
public interface PacientesClientRest {
    @GetMapping("/ordenes/{id}")
    Object obtenerOrden(@PathVariable("id") Long id);
}
