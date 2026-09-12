package org.diagnoslab.resultados.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.*;
import java.util.*;

@Entity
public class RegistroResultado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long ordenAtencionId;
    @NotNull
    private Long muestraId;
    private String estadoValidacion = "PENDIENTE";
    private LocalDateTime fechaRegistro = LocalDateTime.now();
    private LocalDateTime fechaValidacion;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "registro_resultado_id")
    private List<ValorResultado> valores = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public Long getOrdenAtencionId() {
        return ordenAtencionId;
    }

    public void setOrdenAtencionId(Long v) {
        ordenAtencionId = v;
    }

    public Long getMuestraId() {
        return muestraId;
    }

    public void setMuestraId(Long v) {
        muestraId = v;
    }

    public String getEstadoValidacion() {
        return estadoValidacion;
    }

    public void setEstadoValidacion(String v) {
        estadoValidacion = v;
    }

    public LocalDateTime getFechaValidacion() {
        return fechaValidacion;
    }

    public void setFechaValidacion(LocalDateTime v) {
        fechaValidacion = v;
    }

    public List<ValorResultado> getValores() {
        return valores;
    }

    public void setValores(List<ValorResultado> v) {
        valores = v;
    }
}
