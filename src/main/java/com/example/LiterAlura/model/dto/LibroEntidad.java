package com.example.LiterAlura.model.dto;

import com.example.LiterAlura.model.DatosLibro;
import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Entity
@Table(name = "libros")
public class LibroEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)
    private String titulo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "autores_id", referencedColumnName = "Id")
    private AutorEntidad autorEntidad;

    private String lenguaje;


    private Integer descargas;




    public LibroEntidad(){}


    public LibroEntidad(DatosLibro datosLibro){
        this.titulo=datosLibro.title();
        this.autorEntidad=null;
                Optional<AutorEntidad> autor = datosLibro.autores().stream().map(AutorEntidad::new).findFirst();
                if(autor.isPresent()){
                    this.autorEntidad=autor.get();
                }
        this.lenguaje=null;
                Optional<String> lengua = datosLibro.lenguajes().stream().findFirst();
                if(lengua.isPresent()){
                    this.lenguaje=lengua.get();
                }
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

    public AutorEntidad getAutorEntidad() {
        return autorEntidad;
    }

    public void setAutorEntidad(AutorEntidad autorEntidad) {
        this.autorEntidad = autorEntidad;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
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
                "Autor = " + autorEntidad + '\n' +
                "lenguajes = " + lenguaje +'\n'+
                "descargas = " + descargas+'\n'+
                "*********************************************";
    }
}
