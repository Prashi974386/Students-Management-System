package com.ty.studentmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.studentmanagementsystem.dto.Address;
import com.ty.studentmanagementsystem.dto.Admin;
import com.ty.studentmanagementsystem.dto.Course;
import com.ty.studentmanagementsystem.dto.Login;
import com.ty.studentmanagementsystem.dto.ResponseStructure;
import com.ty.studentmanagementsystem.dto.Student;
import com.ty.studentmanagementsystem.service.AddressService;
import com.ty.studentmanagementsystem.service.AdminService;
import com.ty.studentmanagementsystem.service.CourseService;
import com.ty.studentmanagementsystem.service.StudentService;

import lombok.extern.java.Log;

@RestController
public class AdminController {
	@Autowired
	AdminService service;
	@Autowired
	StudentService studentService;
	@Autowired
	CourseService courseService;
	@Autowired
	AddressService addressService;
	
	@PostMapping("/admins")
	public ResponseStructure<Admin> saveAdmin(@RequestBody Admin admin) {
		return service.saveAdmin(admin);
	}
	
	@GetMapping("/admins/login")
	public ResponseStructure<Admin> loginAdmin(@RequestBody Login login) {
		return service.loginAdmin(login);
	}
	
	@PostMapping("/admins/students")
	public ResponseStructure<Student> saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@PostMapping("/admins/students/address")
	public ResponseStructure<Address> saveAddress(@RequestBody Address address,@RequestParam String code) {
		return addressService.saveAddress(address,code);
	}
	
	@PostMapping("/admins/courses")
	public ResponseStructure<Course> saveCourse(@RequestBody Course course) {
		return courseService.saveCourse(course);
	}
	
	@PostMapping("/admins/students/assign")
	public ResponseStructure<Student> assignCourses(@RequestParam String uniqecode,@RequestParam int cid) {
		return studentService.assignCourses(uniqecode, cid);
	}
	
	@GetMapping("/admins/students")
	public ResponseStructure<List<Student>> getStudentsByName(@RequestParam String name){
		return studentService.getStudentsByName(name);
	}
	
	@GetMapping("/admins/courses")
	public ResponseStructure<List<Student>> getStudentsByCourse(@RequestParam int id){
		return courseService.getStudentByCourse(id);
	}
	
	
}
