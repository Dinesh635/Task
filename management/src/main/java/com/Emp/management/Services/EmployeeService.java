package com.Emp.management.Services;

import com.Emp.management.Entity.Employee;
import com.Emp.management.Exceptions.EmployeeNotFoundException;
import com.Emp.management.Exceptions.WrongEmployeeDetailException;

import java.util.List;

public interface EmployeeService {

    public Employee getEmployeeById(int id) throws EmployeeNotFoundException;

    public List<Employee> getAllEmployee() throws EmployeeNotFoundException;

    public void removeEmployee(int id) throws EmployeeNotFoundException;

    public Employee updateEmployee(Employee employee,int id) throws EmployeeNotFoundException;

    public void addEmployee(Employee employee) throws WrongEmployeeDetailException;

}
