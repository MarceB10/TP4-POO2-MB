package Ejercicio3.persistence;

import Ejercicio3.modelo.Concurso;
import Ejercicio3.modelo.RepositorioConcursos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArchivoRepositorioConcurso implements RepositorioConcursos {
    private String rutaArchivo;

    public ArchivoRepositorioConcurso(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo; // Ejemplo: "Concursos.txt"
    }

    @Override
    public List<Concurso> obtenerConcursos() {
        List<Concurso> concursos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String encabezado = br.readLine();
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length < 4) {
                    throw new RuntimeException("Línea con formato incorrecto: " + linea);
                }
                int id = Integer.parseInt(partes[0].trim());
                String nombre = partes[1].trim();
                LocalDate inicio = LocalDate.parse(partes[2].trim());
                LocalDate fin = LocalDate.parse(partes[3].trim());
                concursos.add(new Concurso(id, nombre, inicio, fin));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al leer el archivo de concursos", e);
        }
        return concursos;
    }



}
