package Ejercicio3.modelo;

public class Persona {
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String email;

    public Persona(String nombre, String apellido, String telefono, String dni, String email) {
        checkNombre(nombre);
        checkApellido(apellido);
        checkDni(dni);
        checkTelefono(telefono);
        checkEmail(email);
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
    }

    private void checkEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("El email no puede estar vacío");
        }
        if (!email.matches("^[\\w-\\.]+@[\\w-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("El email no es válido");
        }
    }

    private void checkTelefono(String telefono) {
        if (telefono == null || telefono.isEmpty()) {
            throw new IllegalArgumentException("El teléfono no puede estar vacío");
        }
        if (!telefono.matches("\\d{4}-\\d{6}")) {
            throw new IllegalArgumentException("El teléfono debe tener el formato NNNN-NNNNNN");
        }
    }

    private void checkDni(String dni) {
        if (dni == null || dni.isEmpty()) {
            throw new IllegalArgumentException("El DNI no puede estar vacío");
        }
    }

    private void checkApellido(String apellido) {
        if (apellido == null || apellido.isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío");
        }
    }

    private void checkNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
    }


    public String miNombre() {
        return nombre;
    }

    public String miApellido() {
        return apellido;
    }

    public String miDni() {
        return dni;
    }

    public String miTelefono() {
        return telefono;
    }

    public String miEmail() {
        return email;
    }


}
