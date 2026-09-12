package org.diagnoslab.resultados.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.*;

@Entity
public class Muestra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long ordenAtencionId;
    private String estado = "PENDIENTE";
    private String condicionRechazo;
    private LocalDateTime fechaToma = LocalDateTime.now();
    private String observacionTecnica;

    public Long getId() {
        return id;
    }

    public Long getOrdenAtencionId() {
        return ordenAtencionId;
    }

    public void setOrdenAtencionId(Long v) {
        ordenAtencionId = v;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String v) {
        estado = v;
    }

    public String getCondicionRechazo() {
        return condicionRechazo;
    }

    public void setCondicionRechazo(String v) {
        condicionRechazo = v;
    }

    public String getObservacionTecnica() {
        return observacionTecnica;
    }

    public void setObservacionTecnica(String v) {
        observacionTecnica = v;
    }
}
