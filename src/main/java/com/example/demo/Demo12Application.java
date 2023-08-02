package com.example.demo;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Demo12Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo12Application.class, args);
		
	}
	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
	}
}