package com.example.LiterAlura.model.dto;

import com.example.LiterAlura.model.DatosLibro;

import java.util.List;
import java.util.stream.Collectors;

public class LibroAMostrar {
    private String titulo;

    private List<AutoresAMostrar> autores;
    private List<String> lenguajes;


    private Integer descargas;


    public LibroAMostrar(DatosLibro datosLibro){
        this.titulo=datosLibro.title();
        this.autores=datosLibro.autores().stream().map(AutoresAMostrar::new).collect(Collectors.toList());
        this.lenguajes=datosLibro.lenguajes();
        this.descargas=datosLibro.descargas();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<AutoresAMostrar> getAutores() {
        return autores;
    }

    public void setAutores(List<AutoresAMostrar> autores) {
        this.autores = autores;
    }

    public List<String> getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(List<String> lenguajes) {
        this.lenguajes = lenguajes;
    }

    public Integer getDescargas() {
        return descargas;
    }

    public void setDescargas(Integer descargas) {
        this.descargas = descargas;
    }

    @Override
    public String toString() {
        return  "*********************************************" + '\n' +
                "titulo = " + titulo + '\n' +
                "Autores = " + autores + '\n' +
                "lenguajes =" + lenguajes +'\n'+
                "descargas =" + descargas+'\n'+
                "*********************************************";
    }
}
