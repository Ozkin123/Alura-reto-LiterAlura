package com.example.LiterAlura.model;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(

        @JsonAlias("title") String title,
        @JsonAlias("authors")List<Object> autores,
        @JsonAlias("languages")List<String> lenguajes,
        @JsonAlias("download_count")int descargas

) {
}
