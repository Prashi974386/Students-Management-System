package com.ty.studentmanagementsystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.studentmanagementsystem.dto.Admin;
import com.ty.studentmanagementsystem.dto.Login;
import com.ty.studentmanagementsystem.repository.AdminRepository;

@Repository
public class AdminDao {
	@Autowired
	AdminRepository repository;
	
	
	public Admin saveAdmin(Admin admin) {
		return repository.save(admin);
	}
	
	public Admin loginAdmin(Login login) {
		return repository.loginAdmin(login.getEmail(), login.getPassword());
	}

	
}
