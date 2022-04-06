package com.Emp.management.Controllers;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

import com.Emp.management.Entity.Employee;
import com.Emp.management.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getEmployee()
    {
        List<Employee> list=(List<Employee>) employeeService.getAllEmployee();
        return list;
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {

        return this.employeeService.addEmployee( employee);
    }

    @GetMapping("/employee/{emp_id}")
    public Optional<Employee> getEmployeeById( @PathVariable("emp_id") int emp_id) {

         Optional<Employee> employee=employeeService.getEmployeeById(emp_id);
       return employee;
    }


    @DeleteMapping("/employee/{emp_id}")
    public void removeEmployee(@PathVariable("emp_id") int emp_id) {

            this.employeeService.removeEmployee(emp_id);
    }
   @PutMapping("/employee/{emp_id}")
    public void updateEmployee(@RequestBody Employee employee,@PathVariable("emp_id") int id) {

        this.employeeService.updateEmployee(employee, id);
    }
}
