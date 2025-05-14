package Ejercicio1.model;

public class Participantes {
    private RegistroParticipantes registroDeParticipantes;

    public Participantes(RegistroParticipantes registroDeParticipantes) {
        this.registroDeParticipantes = registroDeParticipantes;
    }

    public void nuevoParticipante(String nombre, String telefono, String region) {
        var participante = new Participante(nombre, telefono, region);
        System.out.println("Nuevo participante agregado: " + nombre);
        this.registroDeParticipantes.registrar(participante);
    }


}
