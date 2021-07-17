package com.salim.system.employees.Exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class EmployeeDBException extends RuntimeException{
    public EmployeeDBException() {
        System.out.println("Employee doesn't exist");
    }
}
