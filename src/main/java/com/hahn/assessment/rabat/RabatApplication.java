package com.hahn.assessment.rabat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class RabatApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabatApplication.class, args);
	}

}
