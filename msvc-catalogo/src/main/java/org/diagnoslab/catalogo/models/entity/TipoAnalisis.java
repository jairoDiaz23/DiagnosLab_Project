package org.diagnoslab.catalogo.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.*;

@Entity
public class TipoAnalisis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String nombre;
    @NotBlank
    private String areaAnalisis;
    private String estado = "ACTIVO";
    private LocalDate fechaRegistro = LocalDate.now();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "tipo_analisis_id")
    private List<Parametro> parametros = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String v) {
        nombre = v;
    }

    public String getAreaAnalisis() {
        return areaAnalisis;
    }

    public void setAreaAnalisis(String v) {
        areaAnalisis = v;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String v) {
        estado = v;
    }

    public List<Parametro> getParametros() {
        return parametros;
    }

    public void setParametros(List<Parametro> v) {
        parametros = v;
    }
}
