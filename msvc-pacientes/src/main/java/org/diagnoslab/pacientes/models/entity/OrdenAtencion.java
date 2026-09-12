package org.diagnoslab.pacientes.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.*;

@Entity
public class OrdenAtencion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long pacienteId;
    private String estado = "PENDIENTE";
    private String medico;
    private String documentoOrdenMedica;
    private LocalDate fechaRegistro = LocalDate.now();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "orden_atencion_id")
    private List<ExamenSolicitado> examenes = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long v) {
        pacienteId = v;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String v) {
        estado = v;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String v) {
        medico = v;
    }

    public String getDocumentoOrdenMedica() {
        return documentoOrdenMedica;
    }

    public void setDocumentoOrdenMedica(String v) {
        documentoOrdenMedica = v;
    }

    public List<ExamenSolicitado> getExamenes() {
        return examenes;
    }

    public void setExamenes(List<ExamenSolicitado> v) {
        examenes = v;
    }
}
