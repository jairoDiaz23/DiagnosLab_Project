package org.diagnoslab.resultados.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

@Entity
public class ValorResultado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long parametroId;
    @NotNull
    private BigDecimal valorMedido;
    private String unidad;
    private String estadoResultado = "NORMAL";

    public Long getId() {
        return id;
    }

    public Long getParametroId() {
        return parametroId;
    }

    public void setParametroId(Long v) {
        parametroId = v;
    }

    public BigDecimal getValorMedido() {
        return valorMedido;
    }

    public void setValorMedido(BigDecimal v) {
        valorMedido = v;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String v) {
        unidad = v;
    }

    public String getEstadoResultado() {
        return estadoResultado;
    }

    public void setEstadoResultado(String v) {
        estadoResultado = v;
    }
}
