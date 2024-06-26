package com.example.LiterAlura.model.dto;

import com.example.LiterAlura.model.DatosAutores;
import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class AutorEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nombre;
    @Column(name = "fecha_nacimiento",nullable = true)
    private int fechaNacimiento;
    @Column(name = "fecha_muerte",nullable = true)
    private int fechaMuerte;



    public AutorEntidad() {
    }

    public AutorEntidad(DatosAutores datosAutores){
        this.nombre= datosAutores.nombre();
        this.fechaNacimiento=datosAutores.fechaNacimiento();
        this.fechaMuerte=datosAutores.fechaMuerte();
    }






    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    @Override
    public String toString() {
        return nombre;
    }
}
