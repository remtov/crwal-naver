package com.batch.ict;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("conf/ex.properties")
public class IctApplication {
	public static void main(String[] args) {
		SpringApplication.run(IctApplication.class, args);
	}
}
