package org.diagnoslab.catalogo.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

@Entity
public class Parametro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nombre;
    @NotBlank
    private String unidadMedida;
    @NotNull
    private BigDecimal rangoMinimo;
    @NotNull
    private BigDecimal rangoMaximo;
    private String sexo;
    private Integer edadMinima;
    private Integer edadMaxima;

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String v) {
        nombre = v;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String v) {
        unidadMedida = v;
    }

    public BigDecimal getRangoMinimo() {
        return rangoMinimo;
    }

    public void setRangoMinimo(BigDecimal v) {
        rangoMinimo = v;
    }

    public BigDecimal getRangoMaximo() {
        return rangoMaximo;
    }

    public void setRangoMaximo(BigDecimal v) {
        rangoMaximo = v;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String v) {
        sexo = v;
    }

    public Integer getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(Integer v) {
        edadMinima = v;
    }

    public Integer getEdadMaxima() {
        return edadMaxima;
    }

    public void setEdadMaxima(Integer v) {
        edadMaxima = v;
    }
}
