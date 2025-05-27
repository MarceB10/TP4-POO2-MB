package Ejercicio2.main;

import Ejercicio2.modelo.EmailService;
import Ejercicio2.modelo.GestorSaludosCumpleaños;
import Ejercicio2.modelo.RepositorioEmpleado;
import Ejercicio2.persistencia.ArchivoRepositorioEmpleado;
import Ejercicio2.servicio.MailTrapEmailService;

public class main {
    public static void main(String[] args) {
        EmailService emailService = new MailTrapEmailService();
        emailService.enviarSaludoCumple("angelbaldome@gmail.com", "Marcelo");
//        RepositorioEmpleado repositorioEmpleado = new ArchivoRepositorioEmpleado("D:\\Marcelo\\Documents\\Sistemas\\Empleados.txt");
//        GestorSaludosCumpleaños gestor = new GestorSaludosCumpleaños(emailService, repositorioEmpleado);
//        gestor.enviarSaludosCumpleaños();

        System.out.println("Gestión de saludos de cumpleaños iniciada.");
    }
}
