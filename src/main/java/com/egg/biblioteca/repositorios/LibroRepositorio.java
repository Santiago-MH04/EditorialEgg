
package com.egg.biblioteca.repositorios;

import com.egg.biblioteca.entidades.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Long>{
        //Método para buscar libro por título
    /*@Query("SELECT l FROM Libro l WHERE l.titulo = :titulo")*/
    public Libro findByTitulo(String titulo);
    
        //Método para buscar libro por nombre de autor
    @Query("SELECT l FROM Libro l WHERE l.autor.nombre = :autor")
    public List<Libro> findByAutor(String autor);
        //Método para buscar libro por nombre de editorial
    @Query("SELECT l FROM Libro l WHERE l.editorial.nombre = :nombre")
    public List<Libro> findByEditorial(@Param(value = "nombre") String editorial);
}
