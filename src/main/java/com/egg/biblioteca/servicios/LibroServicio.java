package com.egg.biblioteca.servicios;


import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.entidades.Libro;
import com.egg.biblioteca.repositorios.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class LibroServicio implements CRUD_Servicio<Libro>{
        //Atributos de LibroServicio
    @Autowired
    private LibroRepositorio repoLibro;

    //Constructores de LibroServicio
    //Asignadores de atributos de LibroServicio (setters)
    //Lectores de atributos de LibroServicio (getters)
        //Métodos de LibroServicio
    @Override
    public List<Libro> mostrarTodos() {
        return this.repoLibro.findAll();
    }
        public List<Libro> mostrarTodosAutor(String autor) {
            return this.repoLibro.findByAutor(autor);
        }
        public List<Libro> mostrarTodosEditorial(String editorial) {
            return this.repoLibro.findByEditorial(editorial);
        }

    @Override
    public Optional<Libro> buscarPorId(Object id) {
        return this.repoLibro.findById((Long) id);
    }

    @Override
    public Libro guardar(Libro libro) {
        return this.repoLibro.save(libro);
    }

    @Override
    public Optional<Libro> actualizar(Libro libro, Object id) {
        Optional<Libro> libroBD = this.buscarPorId((Long) id);
        if(libroBD.isPresent()){
            return Optional.of(this.repoLibro.save(libro));
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(Object id) {
        this.repoLibro.findById((Long) id)
                .ifPresent(this.repoLibro::delete);
    }
}
