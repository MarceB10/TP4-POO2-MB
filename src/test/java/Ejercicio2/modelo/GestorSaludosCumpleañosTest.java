package Ejercicio2.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class GestorSaludosCumpleañosTest {

    @Test
    public void Test1() {
        var fakeEmailService = new FakeEmailService();
        var fakeRepositorioEmpleado = new FakeRepositorioEmpleado();
        var gestorSaludosCumpleaños = new GestorSaludosCumpleaños(fakeEmailService, fakeRepositorioEmpleado);

        gestorSaludosCumpleaños.enviarSaludosCumpleaños();
        assertEquals("messi@gmail.com", fakeEmailService.fakeEmailEs());


    }


}