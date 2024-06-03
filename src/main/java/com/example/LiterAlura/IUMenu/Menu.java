package com.example.LiterAlura.IUMenu;

import com.example.LiterAlura.constantes.URLApiGutendex;
import com.example.LiterAlura.model.DatosLibro;
import com.example.LiterAlura.model.DatosListaLibros;

import com.example.LiterAlura.model.dto.LibroEntidad;
import com.example.LiterAlura.repository.LibrosRepository;
import com.example.LiterAlura.service.ConsumeAPI;
import com.example.LiterAlura.service.ConvierteDatos;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.dao.DataIntegrityViolationException;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Menu {
    private ConsumeAPI consumeApi = new ConsumeAPI();
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private Scanner scanner = new Scanner(System.in);


    private LibrosRepository librosRepository;

    public Menu(LibrosRepository librosRepository) {
        this.librosRepository =librosRepository;
    }


    public void MostrarMenu(){
        int opcion =-1;
        do{
            System.out.println("Que desea hacer");
            System.out.println("1. Buscar Libro por titulo");
            System.out.println("2. Listar libros registrados");
            System.out.println("3. Listar autores registrados");
            System.out.println("4. Listar autores vivos en determinado año");
            System.out.println("5. Listar libros por idioma");
            System.out.println();
            System.out.println();
            System.out.println("0. Salir"
            );


            try {
                opcion= scanner.nextInt();
                scanner.nextLine();
            }catch (InputMismatchException e){
            }
            switch (opcion){
                case 1:
                    System.out.println("Escriba libro deseado");
                    try {
                        buscarLibro();
                    }catch (DataIntegrityViolationException e){
                        System.out.println("*************************");
                        System.out.println("Libro ya en base de datos");
                        System.out.println("*************************");
                    }

                    break;
                case 2:
                    System.out.println("Libro registrados");
                    listarLibros();
                    break;
                case 3:
                    System.out.println("Autores registrados");
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.println("Autores Vivos");
                    scanner.nextLine();
                    break;
                case 5:
                    System.out.println("Libros por idioma");
                    scanner.nextLine();
                    break;
                case 0:
                    System.out.println("Gracias por su visita");
                    scanner.nextLine();
                    break;
                default:
                    System.out.println("opcion no valida");
                    scanner.nextLine();

            }
        }while (opcion!=0);

        System.out.println("vuelva pronto");


    }
    public  void buscarLibro(){

        String libroDeseado=scanner.nextLine();
        var json = consumeApi.obternerDatos(URLApiGutendex.URL_LIBROS+libroDeseado.replace(" ","%20"));

        var datos= convierteDatos.obtenerDatos(json, DatosListaLibros.class);
        Optional<DatosLibro> libroBusqueda =datos.libros().stream().findFirst();
        if(libroBusqueda.isPresent()){
            LibroEntidad libroEntidad= new LibroEntidad(libroBusqueda.get());
            System.out.println(libroEntidad);
            librosRepository.save(libroEntidad);

        }else {System.out.println("libro no encontrado");
        }

    }

    public void listarLibros(){
        List<LibroEntidad> lista = librosRepository.findAll();
        System.out.println(lista);
    }


}
