package com.example.bibloteca.repository;

import com.example.bibloteca.model.Libro;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibroRepository {

    private List <Libro> listaLibro = new ArrayList<>();

    @PostConstruct
    public void init(){
        
        listaLibro.add(new Libro(1, "978-0134685991", "Effective Java", "Addison-Wesley", 2018, "Joshua Bloch"));
        listaLibro.add(new Libro(2, "978-1617294945", "Spring in Action", "Manning", 2020, "Craig Walls"));
        listaLibro.add(new Libro(3, "978-1491950357", "Designing Data-Intensive Applications", "O'Reilly Media", 2017, "Martin Kleppmann"));
        listaLibro.add(new Libro(4, "978-0132350884", "Clean Code", "Prentice Hall", 2008, "Robert C. Martin"));

    }
}
