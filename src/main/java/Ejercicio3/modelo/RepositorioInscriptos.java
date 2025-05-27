package Ejercicio3.modelo;

import java.util.List;

public interface RepositorioInscriptos {
    List<Persona> obtenerInscriptos(String idConcurso);
    void inscribirPersona(String idConcurso, Persona persona);
}
