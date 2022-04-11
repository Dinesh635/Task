package com.Emp.management.Controllers;

import java.util.ArrayList;
import java.util.List;

import com.Emp.management.Entity.Employee;
import com.Emp.management.Exceptions.EmployeeNotFoundException;
import com.Emp.management.Exceptions.WrongEmployeeDetailException;
import com.Emp.management.Services.ServiceManager;
import com.Emp.management.dto.ApiDto;
import com.Emp.management.dto.EmployeeDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
        List<Employee> employeeList=serviceManager.employeeService.getAllEmployee();

        List<EmployeeDto> DtoList=new ArrayList<>();

        for(Employee employee:employeeList)
        {
            EmployeeDto employeeDto= modelMapper.map(employee,EmployeeDto.class);
            DtoList.add(employeeDto);
        }

        return DtoList;
    }

    @PostMapping("/addEmployee")
    public EmployeeDto addEmployee(@RequestBody  @Valid Employee employee) throws WrongEmployeeDetailException {

           serviceManager.employeeService.addEmployee(employee);
           EmployeeDto employeeDto=modelMapper.map(employee,EmployeeDto.class);

        return employeeDto;
    }

    @GetMapping("/getEmployee")
    public EmployeeDto getEmployeeById( @RequestParam("id") int emp_id) throws EmployeeNotFoundException {

         Employee employee=serviceManager.employeeService.getEmployeeById(emp_id);

          EmployeeDto responseDto=modelMapper.map(employee,EmployeeDto.class);

       return responseDto;
    }


    @DeleteMapping("/removeEmployee")
    public ApiDto removeEmployee(@RequestParam("id") int emp_id) throws EmployeeNotFoundException {

        serviceManager.employeeService.removeEmployee(emp_id);
        ApiDto apiDto=new ApiDto("Employee with ID= "+emp_id+" removed Successfully");

          return apiDto;
    }
   @PutMapping("/updateEmployee")
    public EmployeeDto updateEmployee(@RequestParam("id") int emp_id,@RequestBody @Valid Employee employee) throws EmployeeNotFoundException {

        Employee emp=serviceManager.employeeService.updateEmployee(employee, emp_id);
        EmployeeDto employeeDto=modelMapper.map(emp,EmployeeDto.class);
        return employeeDto;
    }
    @GetMapping("/getByName")
    public List<EmployeeDto> getEmployeeByName(@RequestParam("name") String name) throws EmployeeNotFoundException {
        List<Employee> employeeList=serviceManager.employeeService.getEmployeeByName(name);
        List<EmployeeDto> employeeDtoList=new ArrayList<>();
        for(Employee employee:employeeList)
        {
            EmployeeDto employeeDto=modelMapper.map(employee,EmployeeDto.class);
            employeeDtoList.add(employeeDto);
        }
        return employeeDtoList;
    }
}
