package com.ty.studentmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.studentmanagementsystem.dao.AddressDao;
import com.ty.studentmanagementsystem.dao.StudentDao;
import com.ty.studentmanagementsystem.dto.Address;
import com.ty.studentmanagementsystem.dto.ResponseStructure;
import com.ty.studentmanagementsystem.dto.Student;

@Service
public class AddressService {
	@Autowired
	AddressDao dao;
	@Autowired
	StudentDao studentDao;

	public ResponseStructure<Address> saveAddress(Address address, String sid) {
		ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();
		Student student = studentDao.getStudentByUique(sid);
		if (student != null) {
			address.setStudent(student);
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMsg("Data added successfully");
			responseStructure.setData(dao.saveAddress(address));
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Plz try onr more time");
			responseStructure.setData(null);
		}
		return responseStructure;
	}

	public ResponseStructure<Address> updateAddress(Address address, String sid) {
		ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();
		Student student = studentDao.getStudentByUique(sid);
		if (student != null) {
			address.setStudent(student);
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("updated successfully");
			responseStructure.setData(dao.updateAddress(address));
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Plz try onr more time");
			responseStructure.setData(null);
		}
		return responseStructure;
	}
}
