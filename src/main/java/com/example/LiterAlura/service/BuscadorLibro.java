package com.example.LiterAlura.service;

import com.example.LiterAlura.constantes.URLApiGutendex;
import com.example.LiterAlura.model.DatosLibro;
import com.example.LiterAlura.model.DatosListaLibros;

import java.util.Optional;
import java.util.Scanner;

public class BuscadorLibro {

    private Scanner scanner = new Scanner(System.in);
    private ConsumeAPI consumeApi = new ConsumeAPI();
    private  ConvierteDatos convierteDatos = new ConvierteDatos();

    public  void BuscarLibro(String libroDeseado){
        libroDeseado=scanner.nextLine();
        var json = consumeApi.obternerDatos(URLApiGutendex.URL_LIBROS+libroDeseado.replace(" ","%20"));

        var datos= convierteDatos.obtenerDatos(json, DatosListaLibros.class);
        Optional<DatosLibro> libroBusqueda =datos.libros().stream().findFirst();
        if(libroBusqueda.isPresent()){
            System.out.println(libroBusqueda.get());
        }else {System.out.println("libro no encontrado");
        }

    }

}
