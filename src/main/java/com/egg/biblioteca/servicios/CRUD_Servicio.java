package com.egg.biblioteca.servicios;

import java.util.List;
import java.util.Optional;

public interface CRUD_Servicio<T> {
    //Atributos de CRUD_Servicio
    //Constructores de CRUD_Servicio
    //Asignadores de atributos de CRUD_Servicio (setters)
    //Lectores de atributos de CRUD_Servicio (getters)
        //Métodos de CRUD_Servicio
    List<T> mostrarTodos();
    Optional<T> buscarPorId(Object id);
    T guardar(T t);
    Optional<T> actualizar(T t, Object id);
    void eliminar(Object id);
}
