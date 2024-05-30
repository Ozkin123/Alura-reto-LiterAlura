package com.example.LiterAlura.IUMenu;

import com.example.LiterAlura.constantes.URLApiGutendex;
import com.example.LiterAlura.model.DatosListaLibros;
import com.example.LiterAlura.service.ConsumeAPI;
import com.example.LiterAlura.service.ConvierteDatos;
import com.example.LiterAlura.service.MetodoALlamar;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class Menu {


    public static void MostrarMenu(){
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
            Scanner scanner = new Scanner(System.in);

            try {
                opcion= scanner.nextInt();
            }catch (InputMismatchException e){
            }
            switch (opcion){
                case 1:
                    System.out.println("Libro es");
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.println("Libro registrados");
                    scanner.nextLine();
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


}
