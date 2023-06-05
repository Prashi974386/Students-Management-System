package com.ty.studentmanagementsystem.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.studentmanagementsystem.dto.Address;
import com.ty.studentmanagementsystem.dto.Course;
import com.ty.studentmanagementsystem.dto.ResponseStructure;
import com.ty.studentmanagementsystem.dto.Student;
import com.ty.studentmanagementsystem.dto.StudentLogin;
import com.ty.studentmanagementsystem.service.AddressService;
import com.ty.studentmanagementsystem.service.CourseService;
import com.ty.studentmanagementsystem.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService service;
	@Autowired
	CourseService courseService;
	@Autowired
	AddressService addressService;
	
	@GetMapping("/students/login")
	public ResponseStructure<Student> loginStudent(@RequestBody StudentLogin login) {
		return service.loginStudent(login);
	}
	
	@PatchMapping("/students")
	public ResponseStructure<Student> updateStudent(@RequestBody Student student) {
		return service.updateStudent(student);
	}
	
	@PostMapping("/admins/students/uaddress")
	public ResponseStructure<Address> updateAddress(@RequestBody Address address,@RequestParam String code) {
		return addressService.updateAddress(address,code);
	}
	
	@GetMapping("/students")
	public ResponseStructure<List<Course>> getCoursesByStudent(@RequestParam String uniqecode){
		return service.getCoursesByStudent(uniqecode);
	}
	
	@DeleteMapping("/students")
	public ResponseStructure<Course> leaveCourse(@RequestParam int id,@RequestParam String code) {
		return courseService.leaveCourse(id, code);
	}
}
