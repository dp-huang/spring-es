package com.spring.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan(basePackages = { "com.spring.es" })
public class SpringEsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEsApplication.class, args);
	}
}
