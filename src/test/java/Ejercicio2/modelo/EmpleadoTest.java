package Ejercicio2.modelo;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTest {

    @Test
    void testEmpleadoValido() {
        Empleado empleado = new Empleado("Lionel", "messi@gmail.com", LocalDate.of(1987, 6, 24));
        assertEquals("Lionel", empleado.miNombre());
        assertEquals("messi@gmail.com", empleado.miEmail());
        assertEquals(LocalDate.of(1987, 6, 24), empleado.miFechaNacimiento());
    }

    @Test
    void testNombreInvalido() {
        assertThrows(RuntimeException.class,
                () -> new Empleado("", "messi@gmail.com", LocalDate.of(1987, 6, 24)),
                "El nombre no puede estar vacío");
    }

    @Test
    void testEmailInvalidoFormato() {
        assertThrows(RuntimeException.class,
                () -> new Empleado("Lionel", "messi@gmail", LocalDate.of(1987, 6, 24)),
                "El formato del email es inválido");
    }

    @Test
    void testEmailVacio() {
        assertThrows(RuntimeException.class,
                () -> new Empleado("Lionel", "", LocalDate.of(1987, 6, 24)),
                "El email no puede estar vacío");
    }

    @Test
    void testFechaNacimientoInvalida() {
        assertThrows(RuntimeException.class,
                () -> new Empleado("Lionel", "messi@gmail.com", LocalDate.now().plusDays(1)),
                "La fecha de nacimiento no puede ser futura");
    }

    @Test
    void testEsCumpleañosHoy() {
        Empleado empleado = new Empleado("Lionel", "messi@gmail.com", LocalDate.now());
        assertTrue(empleado.esMiCumpleaños(), "El empleado debería estar cumpliendo años hoy");
    }

    @Test
    void testNoEsCumpleañosHoy() {
        Empleado empleado = new Empleado("Lionel", "messi@gmail.com", LocalDate.of(1987, 6, 24));
        assertFalse(empleado.esMiCumpleaños(), "El empleado no debería estar cumpliendo años hoy");
    }
}
