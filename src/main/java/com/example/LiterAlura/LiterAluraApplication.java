package com.example.LiterAlura;

import com.example.LiterAlura.model.DatosLibros;
import com.example.LiterAlura.service.ConsumeAPI;
import com.example.LiterAlura.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumeApi = new ConsumeAPI();
		var json = consumeApi.obternerDatos("http://gutendex.com/books/");
		var conversor = new ConvierteDatos();
		var datos = conversor.obtenerDatos(json, DatosLibros.class);
		System.out.println(datos);

	}
}
