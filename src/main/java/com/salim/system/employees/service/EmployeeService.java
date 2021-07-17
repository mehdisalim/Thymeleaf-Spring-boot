package com.salim.system.employees.service;

import com.salim.system.employees.Exceptions.EmployeeDBException;
import com.salim.system.employees.Repo.EmployeeRepo;
import com.salim.system.employees.model.Employee;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EmployeeService {
    private EmployeeRepo employeeRepo;


    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }

    @ExceptionHandler(value = EmployeeDBException.class)
    public Employee findEmployee(@NotNull Long id){
        return employeeRepo.findById(id).orElse(new Employee());
    }

    public Employee addEmployee(@NotNull Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }
    public Employee updateEmployee(Employee employee,@NotNull Long id){
        Employee employee1=employeeRepo.findById(id).get();
        employee1.setName(employee.getName());
        employee1.setEmail(employee.getEmail());
        employee1.setJobTitle(employee.getJobTitle());
        employee1.setPhone(employee.getPhone());
        employee1.setImageUrl(employee.getImageUrl());
        return employeeRepo.save(employee1);
    }
    public void deleteEmployee(@NotNull Long id){
        employeeRepo.deleteById(id);
    }
    public void deleteAllEmployee(){
        employeeRepo.deleteAll();
    }
}
