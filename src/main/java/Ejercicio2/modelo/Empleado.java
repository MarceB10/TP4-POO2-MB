package Ejercicio2.modelo;

import java.time.LocalDate;

public class Empleado {
    private String nombre;
    private String email;
    private LocalDate fechaNacimiento;

    public Empleado(String nombre, String email, LocalDate fechaNacimiento) {
        checkNombre(nombre);
        checkEmail(email);
        checkFechaNacimiento(fechaNacimiento);

        this.nombre = nombre;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean esMiCumpleaños() {
        LocalDate hoy = LocalDate.now();
        return fechaNacimiento.getDayOfMonth() == hoy.getDayOfMonth() && fechaNacimiento.getMonth() == hoy.getMonth();
    }

    public LocalDate miFechaNacimiento() {
        return fechaNacimiento;
    }

    public String miNombre() {
        return nombre;
    }

    public String miEmail() {
        return email;
    }

    private void checkNombre(String nombre) {
        if (nombre.isBlank()) {
            throw new RuntimeException("El nombre no puede estar vacío");
        }
    }
    private void checkEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        if (email.isBlank()) {
            throw new RuntimeException("El email no puede estar vacío");
        }

        if (!email.matches(regex)) {
            throw new RuntimeException("El formato del email es inválido");
        }
    }
    private void checkFechaNacimiento(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null) {
            throw new RuntimeException("La fecha de nacimiento no puede estar vacía");
        }

        if (fechaNacimiento.isAfter(LocalDate.now())) {
            throw new RuntimeException("La fecha de nacimiento no puede ser futura");
        }
    }


}
