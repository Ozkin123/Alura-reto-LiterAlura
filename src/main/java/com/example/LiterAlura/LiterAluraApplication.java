package com.example.LiterAlura;

import com.example.LiterAlura.IUMenu.Menu;
import com.example.LiterAlura.repository.LibrosRepository;
import com.example.LiterAlura.service.BuscadorLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Optional;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	@Autowired LibrosRepository librosRepository;



	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Menu menu = new Menu(librosRepository);
		menu.MostrarMenu();

	}
}
