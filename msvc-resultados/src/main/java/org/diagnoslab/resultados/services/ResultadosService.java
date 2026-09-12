package org.diagnoslab.resultados.services;

import org.diagnoslab.resultados.models.entity.*;

import java.util.*;

public interface ResultadosService {
    List<Muestra> listarMuestras();

    Optional<Muestra> muestraPorId(Long id);

    Muestra registrarMuestra(Muestra muestra);

    Muestra actualizarEstadoMuestra(Long id, String estado, String motivo);

    List<RegistroResultado> listarRegistros();

    Optional<RegistroResultado> registroPorId(Long id);

    RegistroResultado registrarResultado(RegistroResultado registro);

    RegistroResultado validarRegistro(Long id);
}
