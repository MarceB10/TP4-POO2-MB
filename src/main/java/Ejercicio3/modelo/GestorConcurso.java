package Ejercicio3.modelo;

import java.util.List;

public class GestorConcurso {
    private RepositorioConcursos repositorioConcursos;
    private RepositorioInscriptos repositorioInscriptos;

    public GestorConcurso(RepositorioConcursos repositorioConcursos, RepositorioInscriptos repositorioInscriptos) {
        this.repositorioConcursos = repositorioConcursos;
        this.repositorioInscriptos = repositorioInscriptos;
    }

    public List<Concurso> obtenerConcursosDisponible() {
        return repositorioConcursos.obtenerConcursos();
    }

    public boolean inscripcionAbierta(String idConcurso) {
        Concurso concurso = obtenerConcursoPorId(idConcurso);
        return concurso != null && concurso.inscripcionAbierta();
    }

    public void inscribirPersona(String idConcurso, Persona persona) {
        Concurso concurso = obtenerConcursoPorId(idConcurso);
        if (concurso != null && concurso.inscripcionAbierta()) {
            repositorioInscriptos.inscribirPersona(idConcurso, persona);
        } else {
            throw new IllegalStateException("Inscripción no abierta o concurso no encontrado");
        }
    }


    private Concurso obtenerConcursoPorId(String idConcurso) {
        for (Concurso c : repositorioConcursos.obtenerConcursos()) {
            if (String.valueOf(c.miIdConcurso()).equals(idConcurso)) {
                return c;
            }
        }
        return null;
    }

}
