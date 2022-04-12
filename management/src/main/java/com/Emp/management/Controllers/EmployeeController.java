package com.Emp.management.Controllers;

import com.Emp.management.Entity.Employee;
import com.Emp.management.Exceptions.EmployeeNotFoundException;
import com.Emp.management.Exceptions.EmployeeWrongDetailException;
import com.Emp.management.Services.ServiceManager;
import com.Emp.management.dto.ApiDto;
import com.Emp.management.dto.EmployeeDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController
{
    @Autowired
    private ServiceManager serviceManager;

    @Autowired
    private  ModelMapper modelMapper;



    @GetMapping("/getAllEmployee")
    public List<EmployeeDto> getEmployee()throws EmployeeNotFoundException
    {
        List<EmployeeDto> employeeDtoList=serviceManager.getEmployee();

        return employeeDtoList;
    }

    @PostMapping("/addEmployee")
    public EmployeeDto addEmployee(@RequestBody  @Valid Employee employee) throws EmployeeWrongDetailException {

           serviceManager.employeeService.addEmployee(employee);
           EmployeeDto employeeDto=modelMapper.map(employee,EmployeeDto.class);

        return employeeDto;
    }

    @GetMapping("/getEmployee")
    public EmployeeDto getEmployeeById( @RequestParam("id") int emp_id) throws EmployeeNotFoundException {

         EmployeeDto responseDto=serviceManager.getEmployeeById(emp_id);
       return responseDto;
    }


    @DeleteMapping("/removeEmployee")
    public ApiDto removeEmployee(@RequestParam("id") int emp_id) throws EmployeeNotFoundException {

        ApiDto apiDto=serviceManager.removeEmployee(emp_id);
          return apiDto;
    }

   @PutMapping("/updateEmployee")
    public EmployeeDto updateEmployee(@RequestParam("id") int emp_id,@RequestBody @Valid Employee employee) throws EmployeeNotFoundException, EmployeeWrongDetailException {

        EmployeeDto employeeDto=serviceManager.updateEmployee(employee, emp_id);
        return employeeDto;
    }

    @GetMapping("/getByName")
    public List<EmployeeDto> getEmployeeByName(@RequestParam("name") String name) throws EmployeeNotFoundException {
        List<EmployeeDto> employeeDtoList=serviceManager.getEmployeeByName(name);
        return employeeDtoList;
    }
}
