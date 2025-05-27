package Ejercicio2.modelo;

public class GestorSaludosCumpleaños {
    private EmailService emailService;
    private RepositorioEmpleado repositorioEmpleado;

    public GestorSaludosCumpleaños(EmailService emailService, RepositorioEmpleado repositorioEmpleado) {
        this.emailService = emailService;
        this.repositorioEmpleado = repositorioEmpleado;
    }

    public void enviarSaludosCumpleaños() {
        for (Empleado empleado : repositorioEmpleado.obtenerEmpleados()) {
            if (empleado.esMiCumpleaños()) {
                emailService.enviarSaludoCumple(empleado.miEmail(), empleado.miNombre());
            }
        }
    }

}
