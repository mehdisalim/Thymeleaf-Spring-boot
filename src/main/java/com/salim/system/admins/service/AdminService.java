package com.salim.system.admins.service;

import com.salim.system.admins.Exceptions.AdminDBException;
import com.salim.system.admins.Repo.AdminRepo;
import com.salim.system.admins.model.Admin;
import com.salim.system.employees.Exceptions.EmployeeDBException;
import com.salim.system.employees.model.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AdminService {
    private AdminRepo adminRepo;


    public List<Admin> getAllAdmins(){
        return adminRepo.findAll();
    }
    public Admin findAdmin(Long id){
        return adminRepo.findById(id).orElseThrow(AdminDBException::new);
    }

    public Admin addEmployee(Admin admin){
        admin.setAdminCode(UUID.randomUUID().toString());
        return adminRepo.save(admin);
    }
    public Admin updateAdmin(Admin admin,Long id){
        Admin employee1= adminRepo.findById(id).get();
        employee1.setName(admin.getName());
        employee1.setEmail(admin.getEmail());
        employee1.setJobTitle(admin.getJobTitle());
        employee1.setPhone(admin.getPhone());
        employee1.setImageUrl(admin.getImageUrl());
        return adminRepo.save(employee1);
    }
    public void deleteAdmin(Long id){
        adminRepo.deleteById(id);
    }
    public void deleteAllAdmins(){
        adminRepo.deleteAll();
    }
}
