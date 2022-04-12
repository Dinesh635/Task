package com.Emp.management.Services;

import com.Emp.management.Entity.Employee;
import com.Emp.management.Exceptions.EmployeeNotFoundException;
import com.Emp.management.Exceptions.EmployeeWrongDetailException;
import com.Emp.management.dto.ApiDto;
import com.Emp.management.dto.EmployeeDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceManager {

    @Autowired
    public EmployeeService employeeService;

    @Autowired
    private ModelMapper modelMapper;

    public List<EmployeeDto> getEmployee()throws EmployeeNotFoundException
    {
        List<Employee> employeeList=employeeService.getAllEmployee();

        List<EmployeeDto> DtoList=new ArrayList<>();

        for(Employee employee:employeeList)
        {
            EmployeeDto employeeDto= modelMapper.map(employee,EmployeeDto.class);
            DtoList.add(employeeDto);
        }

        return DtoList;
    }
    public EmployeeDto getEmployeeById( int emp_id) throws EmployeeNotFoundException {

        Employee employee=employeeService.getEmployeeById(emp_id);

        EmployeeDto responseDto=modelMapper.map(employee,EmployeeDto.class);

        return responseDto;
    }
    public EmployeeDto addEmployee( Employee employee) throws EmployeeWrongDetailException {

        employeeService.addEmployee(employee);
        EmployeeDto employeeDto=modelMapper.map(employee,EmployeeDto.class);
        return employeeDto;
    }
    public ApiDto removeEmployee(int emp_id) throws EmployeeNotFoundException {

        employeeService.removeEmployee(emp_id);
        ApiDto apiDto=new ApiDto("Employee with ID= "+emp_id+" removed Successfully");

        return apiDto;
    }

    public EmployeeDto updateEmployee(Employee employee,int emp_id) throws EmployeeNotFoundException, EmployeeWrongDetailException {

        Employee emp=employeeService.updateEmployee(employee, emp_id);
        EmployeeDto employeeDto=modelMapper.map(emp,EmployeeDto.class);
        return employeeDto;
    }
    public List<EmployeeDto> getEmployeeByName(String name) throws EmployeeNotFoundException {
        List<Employee> employeeList=employeeService.getEmployeeByName(name);
        List<EmployeeDto> employeeDtoList=new ArrayList<>();
        for(Employee employee:employeeList)
        {
            EmployeeDto employeeDto=modelMapper.map(employee,EmployeeDto.class);
            employeeDtoList.add(employeeDto);
        }
        return employeeDtoList;
    }
}
