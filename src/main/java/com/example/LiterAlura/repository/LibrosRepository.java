package com.example.LiterAlura.repository;

import com.example.LiterAlura.model.dto.LibroAMostrar;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LibrosRepository extends JpaRepository<LibroAMostrar,Long> {
}
