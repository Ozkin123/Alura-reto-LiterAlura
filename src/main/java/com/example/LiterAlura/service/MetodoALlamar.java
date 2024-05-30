package com.example.LiterAlura.service;

import com.example.LiterAlura.constantes.URLApiGutendex;
import com.example.LiterAlura.model.DatosListaLibros;

import java.util.Optional;
import java.util.Scanner;

public class MetodoALlamar {

    public static void BuscarLibro(){
        Scanner scanner = new Scanner(System.in);
        String libroDeseado;
        System.out.println("Escribe libro deseado");
        libroDeseado=scanner.nextLine();
        var consumeApi = new ConsumeAPI();
        var json = consumeApi.obternerDatos(URLApiGutendex.URL_LIBROS+libroDeseado.replace(" ","%20"));
        ConvierteDatos convierteDatos = new ConvierteDatos();
        var datos= convierteDatos.obtenerDatos(json, DatosListaLibros.class);
        Optional<String> libroBusqueda =datos.libros().stream().map(e->e.title()).findAny();
        if(libroBusqueda.isPresent()){
            System.out.println(libroBusqueda.get());
        }else {System.out.println("libro no encontrado");
        }

    }

}
