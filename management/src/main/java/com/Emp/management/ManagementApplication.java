package com.Emp.management;

import com.Emp.management.Entity.Employee;
import com.Emp.management.Repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class ManagementApplication {

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(ManagementApplication.class, args);

		EmployeeRepository employeeRepository=context.getBean(EmployeeRepository.class);

//         Employee emp=new Employee();
//
//		 emp.setEmp_id(12);
//		 emp.setName("Dinesh");
//		 emp.setDesignation("intern");
//		 emp.setMob_no("8521710363");
//		 emp.setEmail_id("diny@gmail.com");
//
//		 employeeRepository.save(emp);
		System.out.println("Hello World");

	}

}
