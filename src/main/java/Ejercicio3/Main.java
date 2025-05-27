package Ejercicio3;

import Ejercicio3.modelo.*;
import Ejercicio3.persistence.*; // donde estén las implementaciones de RepositorioConcursos e Inscriptos
import Ejercicio3.ui.RadioCompetition;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new Main().start();
            } catch (Exception e) {
                System.out.println(e);
            }
        });
    }

    private void start() {
        RepositorioInscriptos repoInscriptos = new ArchivoRepositorioInscriptos("src/main/resources/inscriptos.txt");
        RepositorioConcursos repoConcursos = new ArchivoRepositorioConcurso("src/main/resources/concurso.txt");

        GestorConcurso gestor = new GestorConcurso(repoConcursos, repoInscriptos);

        new RadioCompetition(gestor);
    }
}
