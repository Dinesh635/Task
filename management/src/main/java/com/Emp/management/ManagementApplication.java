package com.Emp.management;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ManagementApplication {


	@Bean
	public ModelMapper modelMapper() {

		return new ModelMapper();
	}

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(ManagementApplication.class, args);


		//EmployeeDao employeeRepository = context.getBean(EmployeeDao.class);

		System.out.println("Hello World");

	}
}
