package com.example.demo;

import com.example.demo.Entidade.SensorTemperatura;
import com.example.demo.Entidade.SensorLuz;
import com.example.demo.Repositorio.SensorLuzRepository;
import com.example.demo.Repositorio.SensorTemperaturaRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;


@SpringBootApplication
@OpenAPIDefinition
public class ApiSensoresApplication implements CommandLineRunner {

	@Autowired
	private SensorTemperaturaRepository repositorytemp;

	@Autowired
	private SensorLuzRepository repositoryluz;

	public static void main(String[] args) {
		SpringApplication.run(ApiSensoresApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repositorytemp.deleteAll();
		repositoryluz.deleteAll();

		// criar sensores
		Random random = new Random();


		repositorytemp.save(new SensorTemperatura(random.nextInt(600)/10.0, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())));
		repositorytemp.save(new SensorTemperatura(random.nextInt(600)/10.0, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())));
		repositorytemp.save(new SensorTemperatura(random.nextInt(600)/10.0, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())));
		repositorytemp.save(new SensorTemperatura(random.nextInt(600)/10.0, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())));
		repositorytemp.save(new SensorTemperatura(random.nextInt(600)/10.0, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())));

		repositoryluz.save(new SensorLuz(random.nextInt(10000), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())));
		repositoryluz.save(new SensorLuz(random.nextInt(10000), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())));
		repositoryluz.save(new SensorLuz(random.nextInt(10000), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())));
		repositoryluz.save(new SensorLuz(random.nextInt(10000), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())));
		repositoryluz.save(new SensorLuz(random.nextInt(10000), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())));

		//fazer find de valor acima de X??

	}
}
