package com.salim.system.admins.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Admins")
@Table(name = "admins",uniqueConstraints = {@UniqueConstraint(name = "admin_email_unique",columnNames = "email")})
@Data
@NoArgsConstructor
public class Admin implements Serializable {

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

    @Column(name = "ADMIN_CODE",nullable = false,updatable = false)
    private String adminCode;

    public Admin(String name, String email, String jobTitle, String phone, String imageUrl, String employeeCode) {
        this.name = name;
        this.email = email;
        this.jobTitle = jobTitle;
        this.phone = phone;
        this.imageUrl = imageUrl;
        this.adminCode = employeeCode;
    }

}
