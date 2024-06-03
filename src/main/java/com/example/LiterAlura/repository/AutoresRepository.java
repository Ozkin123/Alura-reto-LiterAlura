package com.example.LiterAlura.repository;

import com.example.LiterAlura.model.dto.AutorEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutoresRepository extends JpaRepository<AutorEntidad,Long> {

    @Query("SELECT s FROM AutorEntidad s WHERE s.fechaMuerte < :fecha" )
    List<AutorEntidad> autoresVivosEnDetermiandaFecha(int fecha);




}
