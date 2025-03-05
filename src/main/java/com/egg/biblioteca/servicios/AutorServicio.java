package com.egg.biblioteca.servicios;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.repositorios.AutorRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AutorServicio implements CRUD_Servicio<Autor>{
        //Atributos de AutorServicio
    private final AutorRepositorio repoAutor;

        //Constructores de AutorServicio
    public AutorServicio(AutorRepositorio repoAutor) {
        this.repoAutor = repoAutor;
    }

    //Asignadores de atributos de AutorServicio (setters)
    //Lectores de atributos de AutorServicio (getters)
        //Métodos de AutorServicio
    @Override
    public List<Autor> mostrarTodos() {
        return this.repoAutor.findAll();
    }

    @Override
    public Optional<Autor> buscarPorId(Object id) {
        return this.repoAutor.findById((UUID) id);
    }

    @Override
    public Autor guardar(Autor autor) {
        return this.repoAutor.save(autor);
    }

    @Override
    public Optional<Autor> actualizar(Autor autor, Object id) {
        Optional<Autor> autorBD = this.buscarPorId((UUID) id);
        if(autorBD.isPresent()){
            return Optional.of(this.repoAutor.save(autor));
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(Object id) {
        this.buscarPorId((UUID) id)
                .ifPresent(this.repoAutor::delete);
    }
}
