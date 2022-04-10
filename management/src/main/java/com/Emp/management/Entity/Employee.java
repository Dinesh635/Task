package com.Emp.management.Entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name ="empTable")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int EmployeeId;

    @NotEmpty(message = "Please Enter your name")
    @Size(min =3,max=30,message="Number of characters must be between 3 and 30")
    @Pattern(regexp = "^[a-zA-Z]+(\\s[a-zA-Z]+)?$",message = "Your name  must contain alphabets only")
     private String name;

    @Enumerated(value = EnumType.STRING)
    @NotNull(message = "Please Enter designation")
    private EmployeeDesignations Designation;

    @NotEmpty(message = "Please enter your mobile number")
    @Pattern(regexp = "^\\d{10}$",message = "Please enter valid mobile number")
    private String mob_no;

    //@Pattern(regexp = "+",message = "Salary must have digits only")
    @Min(value = 0,message = "Salary can not be negative")
    @Max(value = 10000000,message = "Invalid salary")
    private int salary;

    @NotEmpty(message = "Please enter your E-mail")
    @Email(message = "Invalid Email")
    private String email_id;

    public Employee() {

    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeDesignations getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = EmployeeDesignations.valueOf(designation);
    }

    public String getMob_no() {
        return mob_no;
    }

    public void setMob_no(String mob_no) {
        this.mob_no = mob_no;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
