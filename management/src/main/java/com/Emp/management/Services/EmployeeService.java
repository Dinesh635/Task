package com.Emp.management.Services;

import com.Emp.management.Entity.Employee;
import com.Emp.management.Exceptions.EmployeeNotFoundException;
import com.Emp.management.Exceptions.EmployeeWrongDetailException;

import java.util.List;

public interface EmployeeService {

    Employee getEmployeeById(int id) throws EmployeeNotFoundException;

    List<Employee> getAllEmployee() throws EmployeeNotFoundException;

     void removeEmployee(int id) throws EmployeeNotFoundException;

     Employee updateEmployee(Employee employee,int id) throws EmployeeNotFoundException, EmployeeWrongDetailException;

     void addEmployee(Employee employee) throws EmployeeWrongDetailException;

     List<Employee> getEmployeeByName(String name) throws EmployeeNotFoundException;

}
