package Ejercicio2.modelo;

public class FakeEmailService implements EmailService {
    String destinatario;

    public FakeEmailService() { }

    @Override
    public void enviarSaludoCumple(String destinatario, String nombre) {
        this.destinatario = destinatario;
    }

    public String fakeEmailEs() {
        return destinatario;
    }
}