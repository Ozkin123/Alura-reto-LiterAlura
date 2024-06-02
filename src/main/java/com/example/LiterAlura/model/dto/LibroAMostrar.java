package com.example.LiterAlura.model.dto;

import com.example.LiterAlura.model.DatosLibro;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "libros")
public class LibroAMostrar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)
    private String titulo;


    @OneToMany(mappedBy = "libroAMostrar", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AutoresAMostrar> autores;


    private List<String> lenguajes;


    private Integer descargas;

    public LibroAMostrar(){}


    public LibroAMostrar(DatosLibro datosLibro){
        this.titulo=datosLibro.title();
        this.autores=datosLibro.autores().stream().map(AutoresAMostrar::new).collect(Collectors.toList());
        this.lenguajes=datosLibro.lenguajes();
        this.descargas=datosLibro.descargas();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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
        autores.forEach(e->e.setLibroAMostrar(this));
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
