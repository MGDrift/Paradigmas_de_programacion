package com.paradigmas.subasta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableMongoRepositories(basePackages = "com.paradigmas.subasta.repository")
public class SubastaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubastaApplication.class, args);
	}

}
