package com.Emp.management.Services;

import com.Emp.management.Entity.Employee;
import com.Emp.management.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeService {

    
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeService() {
    }


    public List<Employee> getAllEmployee()
    {
       List<Employee> allEmployeeDetails=(List)employeeRepository.findAll();
        return allEmployeeDetails;
    }

    public Optional<Employee> getEmployeeById(int emp_id)
    {
        Optional<Employee> emp=this.employeeRepository.findById(emp_id);

        return emp;
    }

    public Employee addEmployee(Employee employee)
    {
        Employee emp=this.employeeRepository.save(employee);
        return emp;
    }
    public void removeEmployee(int emp_id)
    {

        this.employeeRepository.deleteById(emp_id);
    }

    public void updateEmployee(Employee employee,int emp_id)
    {
        employee.setEmp_id(emp_id);
        this.employeeRepository.save(employee);
    }

}
