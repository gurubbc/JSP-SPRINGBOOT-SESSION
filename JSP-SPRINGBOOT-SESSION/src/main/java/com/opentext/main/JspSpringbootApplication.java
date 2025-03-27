package com.opentext.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.opentext")
public class JspSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(JspSpringbootApplication.class, args);
	}

}
