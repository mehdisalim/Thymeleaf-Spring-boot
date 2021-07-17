package com.salim.system.employees.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity(name = "Employees")
@Table(name = "employees",uniqueConstraints = {@UniqueConstraint(name = "employee_email_unique",columnNames = "email")})
@Data
@NoArgsConstructor
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false,updatable = false)
    private Long id;

    @Column(name = "name",nullable = false,columnDefinition = "TEXT")
    private String name;

    @Column(name = "email",nullable = false,columnDefinition = "TEXT")
    private String email;

    @Column(name = "job_title",nullable = false,columnDefinition = "TEXT")
    private String jobTitle;

    @Column(name = "phone",nullable = false,columnDefinition = "TEXT")
    private String phone;

    @Column(name = "image_url",nullable = false,columnDefinition = "TEXT")
    private String imageUrl;

    @Column(name = "EMPLOYEE_CODE",nullable = false,updatable = false)
    private String employeeCode;

    @Column(name = "CREATED_TIME",updatable = false)
    private LocalDateTime created;
    @Column(name = "LAST_MODIFIED_TIME")
    private LocalDateTime modified;

    @PrePersist
    public void onCreated(){
        this.setCreated(LocalDateTime.now());
    }
    @PreUpdate
    public void onModified(){
        this.setModified(LocalDateTime.now());
    }
    @PreRemove
    public void onRemove(){
        this.setModified(LocalDateTime.now());
    }

}
