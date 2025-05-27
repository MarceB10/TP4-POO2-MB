package Ejercicio2.persistencia;

import Ejercicio2.modelo.Empleado;
import Ejercicio2.modelo.RepositorioEmpleado;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArchivoRepositorioEmpleado implements RepositorioEmpleado {
    private String rutaArchivo;
    // Implementación de los métodos del repositorio de empleados
    // Aquí se pueden usar operaciones de archivo para guardar, buscar, etc.

    public ArchivoRepositorioEmpleado(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }
    //implementado BufferedReader y FileReader
    public List<Empleado> obtenerEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 4) {
                    String apellido = partes[0].trim();
                    String nombre = partes[1].trim();
                    LocalDate fechaNac = LocalDate.parse(partes[2].trim());
                    String email = partes[3].trim();
                    empleados.add(new Empleado(nombre, email, fechaNac));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empleados;
    }

}
