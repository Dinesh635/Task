package com.Emp.management.dao;

import com.Emp.management.Entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee,Integer> {

     List<Employee> findByName(String name);
}
