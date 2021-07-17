package com.salim.system;

import com.salim.system.employees.model.Employee;
import com.salim.system.employees.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeResources {
    private final EmployeeService employeeService;

    @GetMapping(value = "/all")
    @CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*",allowCredentials = "true" )
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employees=employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    @CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*",allowCredentials = "true" )
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id){
        Employee employee=employeeService.findEmployee(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    @CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*",allowCredentials = "true" )
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee addEmployee=employeeService.addEmployee(employee);
        return new ResponseEntity<>(addEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*",allowCredentials = "true" )
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable("id") Long id){
        Employee updateemployee=employeeService.updateEmployee(employee,id);
        return new ResponseEntity<>(updateemployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*",allowCredentials = "true" )
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/all")
    @CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*",allowCredentials = "true" )
    public ResponseEntity<?> deleteAllEmployee(){
        employeeService.deleteAllEmployee();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
