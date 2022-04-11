package com.Emp.management.Services;

import com.Emp.management.Entity.Employee;
import com.Emp.management.Exceptions.EmployeeNotFoundException;
import com.Emp.management.Exceptions.EmployeeWrongDetailException;
import com.Emp.management.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private  EmployeeDao employeeDao;


    @Override
    public Employee getEmployeeById(int id) throws EmployeeNotFoundException {

        Optional<Employee> employee=employeeDao.findById(id);
        if(employee.isPresent())
            return employee.get();
     else
         throw new EmployeeNotFoundException("Employee with id "+id+"does not exist");
    }

    @Override
    public List<Employee> getAllEmployee() throws EmployeeNotFoundException {
        List<Employee> employeeList = (List<Employee>) employeeDao.findAll();
        if (employeeList.size() > 0)
            return employeeList;
        else {
            throw new EmployeeNotFoundException("Database is empty");
        }
    }


    @Override
    public void removeEmployee(int id) throws EmployeeNotFoundException {

         Optional<Employee> employeeOptional=employeeDao.findById(id);

        if(employeeOptional.isPresent())
              employeeDao.deleteById(id);
        else
            throw new EmployeeNotFoundException("We do not employee with id : "+id);
    }

    @Override
    public Employee updateEmployee(Employee employee, int id) throws EmployeeNotFoundException {

        Optional<Employee> employeeOptional=employeeDao.findById(id);
        if(employeeOptional.isPresent())
        {
            Employee emp=employeeOptional.get();
            employee.setEmployeeId(id);
            Employee savedEmployee=employeeDao.save(employee);
            return savedEmployee;
        }
       else {
            throw new EmployeeNotFoundException("Employee with id : " + id + "not found.");
        }
    }

    @Override
    public void addEmployee(Employee employee) throws EmployeeWrongDetailException {
        employeeDao.save(employee);
    }

    @Override
    public List<Employee> getEmployeeByName(String name) throws EmployeeNotFoundException {
        List<Employee> employeeList=employeeDao.findByName(name);

        if(employeeList.size()>0)
            return employeeList;
        else{
            throw new EmployeeNotFoundException("Employee name : "+name+" not found");
        }
    }

}
