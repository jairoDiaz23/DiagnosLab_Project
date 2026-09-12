package org.diagnoslab.pacientes.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class ExamenSolicitado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long tipoAnalisisId;
    private String indicacionPrevia;
    private boolean registradoEnCatalogo;

    public Long getId() {
        return id;
    }

    public Long getTipoAnalisisId() {
        return tipoAnalisisId;
    }

    public void setTipoAnalisisId(Long v) {
        tipoAnalisisId = v;
    }

    public String getIndicacionPrevia() {
        return indicacionPrevia;
    }

    public void setIndicacionPrevia(String v) {
        indicacionPrevia = v;
    }

    public boolean isRegistradoEnCatalogo() {
        return registradoEnCatalogo;
    }

    public void setRegistradoEnCatalogo(boolean v) {
        registradoEnCatalogo = v;
    }
}
