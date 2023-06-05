package com.ty.studentmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.studentmanagementsystem.dao.AdminDao;
import com.ty.studentmanagementsystem.dto.Admin;
import com.ty.studentmanagementsystem.dto.Login;
import com.ty.studentmanagementsystem.dto.ResponseStructure;

@Service
public class AdminService {
	@Autowired
	AdminDao dao;
	
	public ResponseStructure<Admin> saveAdmin(Admin admin) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		if(admin != null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMsg("Saved Successfully");
			responseStructure.setData(dao.saveAdmin(admin));
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Plz try One More Time");
			responseStructure.setData(null);
		}
		return responseStructure;
	}
	
	public ResponseStructure<Admin> loginAdmin(Login login) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		if(login != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("login Successfully");
			responseStructure.setData(dao.loginAdmin(login));
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Password and email missmatch");
			responseStructure.setData(null);
		}
		return responseStructure;
	}
}
