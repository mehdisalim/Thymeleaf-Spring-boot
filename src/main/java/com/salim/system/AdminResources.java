package com.salim.system;

import com.salim.system.admins.model.Admin;
import com.salim.system.admins.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
@AllArgsConstructor
public class AdminResources {
    private final AdminService adminService;


    @GetMapping("/all")
    public ResponseEntity<List<Admin>> getAllAdmin(){
        List<Admin> admins=adminService.getAllAdmins();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Admin> getEmployee(@PathVariable("id") Long id){
        Admin admin=adminService.findAdmin(id);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Admin> addEmployee(@RequestBody Admin employee){
        Admin addAdmin=adminService.addEmployee(employee);
        return new ResponseEntity<>(addAdmin, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Admin> updateEmployee(@RequestBody Admin employee,@PathVariable("id") Long id){
        Admin updateAdmin=adminService.updateAdmin(employee,id);
        return new ResponseEntity<>(updateAdmin, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        adminService.deleteAdmin(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<?> deleteAllEmployee(){
        adminService.deleteAllAdmins();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
