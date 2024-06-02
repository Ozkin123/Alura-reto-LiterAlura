package com.example.LiterAlura.model.dto;

import com.example.LiterAlura.model.DatosAutores;
import jakarta.persistence.*;


@Entity
@Table(name = "autores")
public class AutoresAMostrar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nombre;
    @Column(name = "fecha_nacimiento",nullable = true)
    private int fechaNacimiento;
    @Column(name = "fecha_muerte",nullable = true)
    private int fechaMuerte;

    @ManyToOne
    private LibroAMostrar libroAMostrar;

    public AutoresAMostrar(){}

    public AutoresAMostrar(DatosAutores datosAutores){
        this.nombre= datosAutores.nombre();
        this.fechaNacimiento=datosAutores.fechaNacimiento();
        this.fechaMuerte=datosAutores.fechaMuerte();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(int fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getFechaMuerte() {
        return fechaMuerte;
    }

    public void setFechaMuerte(int fechaMuerte) {
        this.fechaMuerte = fechaMuerte;
    }

    public LibroAMostrar getLibroAMostrar() {
        return libroAMostrar;
    }

    public void setLibroAMostrar(LibroAMostrar libroAMostrar) {
        this.libroAMostrar = libroAMostrar;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
