package Ejercicio3.persistence;

import Ejercicio3.modelo.Persona;
import Ejercicio3.modelo.RepositorioInscriptos;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoRepositorioInscriptos implements RepositorioInscriptos {
    private String rutaArchivo;

    public ArchivoRepositorioInscriptos(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;

    }

    @Override
    public List<Persona> obtenerInscriptos(String idConcurso) {
        List<Persona> inscriptos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String idConcursoArchivo = partes[0].trim();
                if (idConcursoArchivo.equals(idConcurso)) {
                    String nombre = partes[1].trim();
                    String apellido = partes[2].trim();
                    String telefono = partes[3].trim();
                    String email = partes[4].trim();
                    String dni = partes[5].trim();
                    inscriptos.add(new Persona(nombre, apellido, telefono, dni, email));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al leer el archivo de inscriptos", e);
        }
        return inscriptos;
    }

    @Override
    public void inscribirPersona(String idConcurso, Persona persona) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            String linea = String.format("%s, %s, %s, %s, %s, %s",
                    persona.miNombre(),
                    persona.miApellido(),
                    persona.miTelefono(),
                    persona.miEmail(),
                    persona.miDni(),
                    idConcurso);
            bw.write(linea);
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Error al escribir en el archivo de inscriptos", e);
        }
    }

}
