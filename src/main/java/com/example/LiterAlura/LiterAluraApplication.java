package com.example.LiterAlura;

import com.example.LiterAlura.IUMenu.Menu;
import com.example.LiterAlura.repository.AutoresRepository;
import com.example.LiterAlura.repository.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	@Autowired LibrosRepository librosRepository;

	@Autowired
	AutoresRepository autoresRepository;



	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Menu menu = new Menu(librosRepository, autoresRepository);
		menu.MostrarMenu();

	}
}
