package Ejercicio3.modelo;

import java.time.LocalDate;

public class Concurso {
    private int idConcurso;
    private String nombreConcurso;
    private LocalDate fechaInicioInscripcion;
    private LocalDate fechaFinInscripcion;

    public Concurso(int idConcurso, String nombreConcurso, LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion) {
//        checkIdConcurso(idConcurso);
//        checkNombreConcurso(nombreConcurso);
//        checkfechaInicioInscripcion(fechaInicioInscripcion);
//        checkfechaFinInscripcion(fechaFinInscripcion);
        this.idConcurso = idConcurso;
        this.nombreConcurso = nombreConcurso;
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.fechaFinInscripcion = fechaFinInscripcion;
    }

    public int miIdConcurso() {
        return idConcurso;
    }

    public String miNombreConcurso() {
        return nombreConcurso;
    }
    public LocalDate miFechaInicioInscripcion() {
        return fechaInicioInscripcion;
    }
    public LocalDate miFechaFinInscripcion() {
        return fechaFinInscripcion;
    }

    public boolean inscripcionAbierta(){
        LocalDate hoy = LocalDate.now();
        return !hoy.isBefore(fechaInicioInscripcion) && !hoy.isAfter(fechaFinInscripcion);
    }
}
