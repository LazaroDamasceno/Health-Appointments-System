package com.example.api.kotlin.v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.modulith.core.ApplicationModules;

@SpringBootApplication
public class V1Application {

	public static void main(String[] args) {
		val modules = ApplicationModules.of(V1Application::class.java)
		modules.verify()
		SpringApplication.run(V1Application.class, args);
	}

}
