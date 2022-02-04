package com.compasso.duvidas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DuvidasApplication {

	public static void main(String[] args) {
		SpringApplication.run(DuvidasApplication.class, args);
	}

}
