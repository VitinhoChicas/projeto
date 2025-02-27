package com.reserva.projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.reserva.projeto")
@EntityScan(basePackages = {"com.reserva.projeto.domains", "com.reserva.projeto.domains.enums"})
@EnableJpaRepositories(basePackages =  "com.reserva.projeto.repositories")
@SpringBootApplication
public class ProjetoApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProjetoApplication.class, args);
	}

}
