package com.Emp.management.dao;

import com.Emp.management.Entity.Employee;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

//@EnableJpaRepositories(basePackages = "com.Emp.management.dao")
public interface EmployeeDao extends CrudRepository<Employee,Integer> {

        //Employee findByEmployeeId(int employeeId);
}
