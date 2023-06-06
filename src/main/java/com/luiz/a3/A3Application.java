package com.luiz.a3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.luiz.a3")
@EntityScan(basePackages = "com.luiz.a3.model.entity")
public class A3Application {
	public static void main(String[] args) {
		SpringApplication.run(A3Application.class, args);
	}
}
