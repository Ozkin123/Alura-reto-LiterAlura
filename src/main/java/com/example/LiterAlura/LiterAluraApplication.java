package com.example.LiterAlura;

import com.example.LiterAlura.constantes.URLApiGutendex;
import com.example.LiterAlura.model.DatosLibro;
import com.example.LiterAlura.model.DatosListaLibros;
import com.example.LiterAlura.service.ConsumeAPI;
import com.example.LiterAlura.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumeApi = new ConsumeAPI();
		var json = consumeApi.obternerDatos(URLApiGutendex.URL_LIBROS+"pi");
		System.out.println(json);
		ConvierteDatos convierteDatos = new ConvierteDatos();
		var datos= convierteDatos.obtenerDatos(json, DatosListaLibros.class);
		//Optional<String> libroBusqueda =datos.libros().stream().map(e->e.title()).findAny();
		//if(libroBusqueda.isPresent()){
		//	System.out.println(libroBusqueda.get());
		//}else System.out.println("libro no encontrado");

		System.out.println(datos);

	}
}
