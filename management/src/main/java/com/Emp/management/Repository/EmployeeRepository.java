package com.Emp.management.Repository;

import java.util.List;
import com.Emp.management.Entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
}
