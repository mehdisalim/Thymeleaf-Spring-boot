package com.salim.system.admins.Repo;

import com.salim.system.admins.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin,Long> {

}
