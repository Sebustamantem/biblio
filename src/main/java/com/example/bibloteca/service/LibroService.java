package com.example.bibloteca.service;

import com.example.bibloteca.model.Libro;
import com.example.bibloteca.repository.LibroRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LibroService {

    private LibroRepository libroRepository;

    //@Autowired
    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> getLibro() {
        return libroRepository.getLibros();
    }

    public Libro getLibroPorId(int id) {
        return libroRepository.getLibroPorId(id);
    }

    public Libro getLibroPorIsbn(String isbn) {
        return libroRepository.getLibroPorIsbn(isbn);
    }

    public Libro getLibroPorAutor(String autor) {
        return libroRepository.getLibroPorAutor(autor);
    }

    public Libro GuardaLibro(Libro libro) {
        return libroRepository.guardarLibro(libro);
    }

    public Libro actualizarLibro(Libro libro) {
        return libroRepository.actualizarLibro(libro);
    }

    public String eliminarLibro(int id) {
        libroRepository.eliminarlibro(id);
        return "Libro Eliminado";
    }

    public int totallibrosV1() {
        return libroRepository.totallibros();
    }

    public Map<Integer, Long> calcularLibroPorAnio() {
        List<Libro> libros = libroRepository.getLibros();

        Map<Integer, Long> libroPorAnio = new HashMap<>();

        for (Libro libro : libros) {
            int anio = libro.getFechapublica();

            long cantidad = libroPorAnio.getOrDefault(anio, 0L) + 1;
            libroPorAnio.put(anio, cantidad);
        }
        return libroPorAnio;
    }

    public Libro getLibroMasAntiguo() {
        List<Libro> libros = libroRepository.getLibros();

        if (libros.isEmpty()) {
            return null;
        }

        Libro libroMasAntiguo = libros.get(0);

        for (Libro libro : libros) {
            if (libro.getFechapublica() < libroMasAntiguo.getFechapublica()) {
                libroMasAntiguo = libro;
            }
        }

        return libroMasAntiguo;
    }
    public Libro getLibroMasNuevo() {
        List<Libro> libros = libroRepository.getLibros();

        if (libros.isEmpty()) {
            return null;
        }

        Libro libroMasNuevo = libros.get(0);

        for (Libro libro : libros) {
            if (libro.getFechapublica() > libroMasNuevo.getFechapublica()) {
                libroMasNuevo = libro;
            }
        }

        return libroMasNuevo;
      
    }

    public List<Libro> listaLibrosOrdenadosPorAnio() {
        

        return LibroRepository.getLibro()
        .stream()
        .sorted((libro1, libro2) -> Integer.compare(libro1.getFechapublica(), libro2.getFechapublica()))
        .toList();

      }


}
