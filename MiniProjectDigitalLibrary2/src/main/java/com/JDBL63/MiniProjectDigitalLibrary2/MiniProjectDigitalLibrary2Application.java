package com.JDBL63.MiniProjectDigitalLibrary2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MiniProjectDigitalLibrary2Application {

	public static void main(String[] args) {
		SpringApplication.run(MiniProjectDigitalLibrary2Application.class, args);
	}

}
