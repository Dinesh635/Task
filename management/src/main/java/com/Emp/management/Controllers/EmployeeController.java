package com.Emp.management.Controllers;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

import com.Emp.management.Entity.Employee;
import com.Emp.management.Services.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController
{

    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee>getEmployee()
    {

        List<Employee> list=employeeService.getAllEmployee();
        return list;
    }
    @GetMapping("/employee/{emp_id}")
    public Optional<Employee> getEmployeeById( @PathVariable("emp_id") int emp_id) {

         Optional<Employee> employee=employeeService.getEmployeeById(emp_id);
       return employee;
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {

       return this.employeeService.addEmployee( employee);
    }
//    @DeleteMapping("/employee/{emp_id}")
//    public Void removeEmployee(@PathVariable("emp_id") int id) {
//
//            this.employeeService.removeEmployee(id);
//    }
    @PutMapping("/employee/{emp_id}")
    public void updateEmployee(@RequestBody Employee employee,@PathVariable("emp_id") int id) {

        this.employeeService.updateEmployee(employee, id);
    }
}
