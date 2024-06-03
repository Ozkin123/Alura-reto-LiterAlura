package com.example.LiterAlura.repository;

import com.example.LiterAlura.model.dto.AutorEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoresRepository extends JpaRepository<AutorEntidad,Long> {
}
