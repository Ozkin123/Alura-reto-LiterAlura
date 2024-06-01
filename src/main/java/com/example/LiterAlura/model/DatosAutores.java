package com.example.LiterAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutores(

        @JsonAlias("birth_year")int fechaNacimiento,
        @JsonAlias("death_year")int fechaMuerte,
        @JsonAlias("name")String nombre


) {
}
