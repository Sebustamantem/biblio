package com.example.bibloteca.model;

import lombok.allArgsConstructor;
import lombok.noArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Libro {

    private int id;
    private String isbn;
    private String titulo;
    private String editorial;
    private String autor;
    private String fechapublicacion;

}
