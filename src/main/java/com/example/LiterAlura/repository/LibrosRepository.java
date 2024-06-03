package com.example.LiterAlura.repository;


import com.example.LiterAlura.model.dto.AutorEntidad;
import com.example.LiterAlura.model.dto.LibroEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface LibrosRepository extends JpaRepository<LibroEntidad,Long> {

    @Query(value = "SELECT * FROM libros WHERE lenguaje ='en'", nativeQuery = true)
     List<LibroEntidad> encontrarPorLenguajeIngles();

    @Query(value = "SELECT * FROM libros WHERE lenguaje ='es'", nativeQuery = true)
    List<LibroEntidad> encontrarPorLenguajeEspaniol();


}
