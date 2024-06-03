package com.example.LiterAlura.repository;


import com.example.LiterAlura.model.dto.AutorEntidad;
import com.example.LiterAlura.model.dto.LibroEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface LibrosRepository extends JpaRepository<LibroEntidad,Long> {




}
