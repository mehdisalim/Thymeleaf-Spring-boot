package com.salim.system.admins.Exceptions;

public class AdminDBException extends RuntimeException{
    public AdminDBException() {
        System.out.println("Admin doesn't exist");
    }
}
