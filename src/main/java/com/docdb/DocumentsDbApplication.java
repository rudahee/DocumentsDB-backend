package com.docdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
public class DocumentsDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocumentsDbApplication.class, args);
	}

}
