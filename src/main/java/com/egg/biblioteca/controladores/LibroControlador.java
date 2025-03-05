package com.egg.biblioteca.controladores;

import com.egg.biblioteca.entidades.Libro;
import com.egg.biblioteca.servicios.LibroServicio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/libros")
public class LibroControlador {
        //Atributos de LibroControlador
    private final LibroServicio libroServicio;

        //Constructores de LibroControlador
    public LibroControlador(LibroServicio libroServicio) {
        this.libroServicio = libroServicio;
    }

    //Asignadores de atributos de LibroControlador (setters)
    //Lectores de atributos de LibroControlador (getters)
        //Métodos de LibroControlador
    @GetMapping
    public List<Libro> listarTodosLibros(){
        return this.libroServicio.mostrarTodos();
    }
        @GetMapping("/{autor}")
        public List<Libro> listarTodosLibrosAutor(@PathVariable String autor){
            return this.libroServicio.mostrarTodosAutor(autor);
        }
        @GetMapping("/{editorial}")
        public List<Libro> listarTodosLibrosEditorial(@PathVariable String editorial){
            return this.libroServicio.mostrarTodosEditorial(editorial);
        }

    @PostMapping
    public Libro crearLibro(Libro libro){
        return this.libroServicio.guardar(libro);
    }

    @PutMapping("/{id}")
    public Libro actualizarLibro(@PathVariable(name = "id") Long isbn, Libro libro){
        return this.libroServicio.actualizar(libro, isbn).orElseThrow();
    }

    @DeleteMapping("{id}")
    public void eliminarLibro(@PathVariable(name = "id") Long isbn){
        this.libroServicio.eliminar(isbn);
    }
}
