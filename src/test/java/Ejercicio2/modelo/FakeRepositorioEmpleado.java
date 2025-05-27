package Ejercicio2.modelo;

import java.time.LocalDate;
import java.util.List;

public class FakeRepositorioEmpleado implements RepositorioEmpleado{
    public FakeRepositorioEmpleado() {
        // Constructor vacío
    }
    public List<Empleado> obtenerEmpleados() {
        // Implementación de prueba que retorna una lista de empleados ficticios
        return List.of(
                new Empleado("Angus",  "angus@acdc.com", LocalDate.of(1982,10,8)),
                new Empleado("Brian" , "brian@acdc.com", LocalDate.of(1975,9,11)),
                new Empleado("Lionel", "messi@gmail.com", LocalDate.now()));

    }


}
