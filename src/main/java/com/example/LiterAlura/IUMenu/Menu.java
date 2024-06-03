package com.example.LiterAlura.IUMenu;

import com.example.LiterAlura.constantes.URLApiGutendex;
import com.example.LiterAlura.model.DatosLibro;
import com.example.LiterAlura.model.DatosListaLibros;

import com.example.LiterAlura.model.dto.AutorEntidad;
import com.example.LiterAlura.model.dto.LibroEntidad;
import com.example.LiterAlura.repository.AutoresRepository;
import com.example.LiterAlura.repository.LibrosRepository;
import com.example.LiterAlura.service.ConsumeAPI;
import com.example.LiterAlura.service.ConvierteDatos;
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
    private AutoresRepository autoresRepository;

    public Menu(LibrosRepository librosRepository,AutoresRepository autoresRepository) {
        this.librosRepository =librosRepository;
        this.autoresRepository=autoresRepository;
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
                    listarAutores();
                    break;
                case 4:
                    System.out.println("Autores Vivos");
                    int fechaRequerida=0;
                    try {
                        fechaRequerida=scanner.nextInt();
                    }catch (InputMismatchException e){
                        System.out.println("opcion no valida");
                    }
                    if(fechaRequerida>2024){
                        fechaRequerida=2023;
                        System.out.println("fecha no valida se asigna fecha 2023");
                    }

                    listarAutoreFecha(fechaRequerida);
                    scanner.nextLine();

                    break;
                case 5:
                    System.out.println("Libros por idioma");
                    System.out.println("Eliga un idioma");
                    System.out.println("1. Libros en Ingles");
                    System.out.println("2. Libros en Español");
                    int opcioBinari = -1;
                     do{
                         try {
                             opcioBinari=scanner.nextInt();
                         }catch (InputMismatchException e){
                             System.out.println("opcion no valida");
                             opcioBinari=0;
                         }

                         switch (opcioBinari){
                             case 1:
                                 listarLibroPorLenguajeIngles();
                                 opcioBinari=0;
                                 break;
                             case 2:
                                 listarLibroPorLenguajeEspaniol();
                                 opcioBinari=0;
                                 break;
                             default:
                                 System.out.println("opcion no valida");
                                 opcioBinari=0;
                         }
                     }while (opcioBinari!=0);
                    break;
                case 0:
                    System.out.println("Gracias por su visita");
                    break;
                default:
                    System.out.println("opcion no valida");

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
    public void listarAutores(){
       List<AutorEntidad> autoresLista = autoresRepository.findAll();
       autoresLista.forEach(System.out::println);

    }

    public void listarLibroPorLenguajeIngles(){
        List<LibroEntidad> listaLibroLengua= librosRepository.encontrarPorLenguajeIngles();
        System.out.println(listaLibroLengua);
    }

    public void listarLibroPorLenguajeEspaniol(){
        List<LibroEntidad> listaLibroLengua= librosRepository.encontrarPorLenguajeEspaniol();
        System.out.println(listaLibroLengua);
    }

    public void listarAutoreFecha(int fechaRequerida){
        List<AutorEntidad> autoresVivos = autoresRepository.autoresVivosEnDetermiandaFecha(fechaRequerida);
        if(autoresVivos.size()==0){
            System.out.println("no hay autores");
        }else System.out.println(autoresVivos);

    }





}
