package com.example.LiterAlura.IUMenu;

import com.example.LiterAlura.service.BuscadorLibro;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

     private String librobuscado;
     private Scanner scanner = new Scanner(System.in);
     private BuscadorLibro buscadorLibro = new BuscadorLibro();

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
            }catch (InputMismatchException e){
            }
            switch (opcion){
                case 1:
                    System.out.println("Escriba libro deseado");
                    librobuscado= scanner.nextLine();
                    buscadorLibro.BuscarLibro(librobuscado);
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
