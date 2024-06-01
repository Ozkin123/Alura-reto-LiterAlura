package com.example.LiterAlura.model.dto;

import com.example.LiterAlura.model.DatosAutores;

public class AutoresAMostrar {
    private String nombre;
    private String fechaNacimiento;
    private String fechaMuerte;

    public AutoresAMostrar(DatosAutores datosAutores){
        this.nombre= datosAutores.nombre();
        this.fechaNacimiento=String.valueOf(datosAutores.fechaNacimiento());
        this.fechaMuerte=String.valueOf(datosAutores.fechaMuerte());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaMuerte() {
        return fechaMuerte;
    }

    public void setFechaMuerte(String fechaMuerte) {
        this.fechaMuerte = fechaMuerte;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
