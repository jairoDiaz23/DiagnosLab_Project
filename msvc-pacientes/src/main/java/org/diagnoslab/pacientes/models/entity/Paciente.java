package org.diagnoslab.pacientes.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Pattern(regexp = "\\d{8}")
    @Column(unique = true, nullable = false)
    private String dni;
    @NotBlank
    private String nombres;
    @Min(0)
    private Integer edad;
    private String sexo;
    private String telefono;
    @Email
    private String correo;
    private LocalDate fechaRegistro = LocalDate.now();

    public Long getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String v) {
        dni = v;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String v) {
        nombres = v;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer v) {
        edad = v;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String v) {
        sexo = v;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String v) {
        telefono = v;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String v) {
        correo = v;
    }
}
