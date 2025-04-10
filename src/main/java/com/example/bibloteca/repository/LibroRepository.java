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

    public List <Libro> geetLibros(){
        return listaLibro;
    }

    public Libro getLibroPorId (int id){
        for(Libro libro :  listaLibro){
            if(libro.getId()== id){
                return libro;
            }
        }
        return null;
    }

    public Libro getLibroPorIsbn (String isbn){ 
        for (Libro libro : listaLibro){
            if(libro.getIsbn() == isbn){
                return libro;
            }
        }
        return null;
    }

        public Libro getLibroPorautor (String autor){
            for(Libro libro : listaLibro){
                if(libro.getAutor()== autor)
                    return libro;
            }
            return null;
        }

        public Libro guardarLibro (Libro libro){
            listaLibro.add(libro);
            return libro;
        }

        public Libro actualizarLibro(Libro libro){
            int id = 0;
            int idPosicion = 0;

            for(int i = 0;i < listaLibro.size(); i++){
                if(listaLibro.get(i).getId()== libro.getId()){
                    id = libro.getId();
                    idPosicion = i;
                }
            }

            Libro libro1 = new Libro();
            libro.setId(id);
            libro.setIsbn(libro.getIsbn());
            libro1.setTitulo(libro.getTitulo());
            libro1.setEditorial(libro.getEditorial());
            libro1.setFechapublica(libro.getFechapublica());
            libro1.setAutor(libro.getAutor());


            listaLibro.set(idPosicion,libro1);

            return libro1;

        }

        public void eliminarlibro (int id){
            
            Libro libro = getLibroPorId(id);
            if (libro != null) listaLibro.remove(libro);

            int idPosicion = 0;
            for (int i = 0; i <listaLibro.size();i++){
                if (listaLibro.get(i).getId()== id){
                    idPosicion = i;
                    break;
                    
                }
            }
                if (idPosicion > 0) listaLibro.remove(idPosicion); 

                listaLibro.removeIf(
                    (x) ->
                    x.getId() == id
                 );
            
            }
            public int totallibros(){
                return listaLibro.size();
            }
        }

    


