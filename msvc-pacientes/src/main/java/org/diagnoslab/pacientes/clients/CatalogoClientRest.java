package org.diagnoslab.pacientes.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "msvc-catalogo", url = "http://localhost:8082/api/catalogo")
public interface CatalogoClientRest {
    @GetMapping("/tipos-analisis/{id}")
    Object obtenerTipoAnalisis(@PathVariable("id") Long id);
}
