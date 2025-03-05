package com.egg.biblioteca.servicios;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.repositorios.EditorialRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class EditorialServicio implements CRUD_Servicio<Editorial>{
        //Atributos de EditorialServicio
    @Autowired
    private EditorialRepositorio repoEditorial;

    //Constructores de EditorialServicio
    //Asignadores de atributos de EditorialServicio (setters)
    //Lectores de atributos de EditorialServicio (getters)
        //Métodos de EditorialServicio
    @Override
    public List<Editorial> mostrarTodos() {
        return this.repoEditorial.findAll();
    }

    @Override
    public Optional<Editorial> buscarPorId(Object id) {
        return this.repoEditorial.findById((UUID) id);
    }

    @Override
    public Editorial guardar(Editorial editorial) {
        return this.repoEditorial.save(editorial);
    }

    @Override
    public Optional<Editorial> actualizar(Editorial editorial, Object id) {
        Optional<Editorial> editorialBD = this.buscarPorId((UUID) id);
        if(editorialBD.isPresent()){
            return Optional.of(this.repoEditorial.save(editorial));
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(Object id) {
        this.repoEditorial.findById((UUID) id)
                .ifPresent(this.repoEditorial::delete);
    }
}
