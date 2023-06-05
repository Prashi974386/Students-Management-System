package com.ty.studentmanagementsystem.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.studentmanagementsystem.dto.Student;
import com.ty.studentmanagementsystem.repository.StudentRepository;

@Repository
public class StudentDao {
	@Autowired
	StudentRepository repository;
	
	public Student saveStudent(Student student) {
		return repository.save(student);
	}
	
	public Student updateStudent(Student student) {
 		 Student student2 = repository.getStudentsByCode(student.getUnique_student_code());
 		 if(student2 != null) {
     		 student2.setEmail(student.getEmail());
     		 student2.setP_name(student.getP_name());
     		 student2.setPhone(student.getPhone());
 			 return repository.save(student2);
 		 }
 		 return null;
	}
	
	public List<Student> getStudentsByName(String name){
		return repository.getStudentsByName(name);
	}
	
	public Student getStudentByUique(String uniqe) {
		return repository.getStudentsByCode(uniqe);
	}
	
	public Student loginStudent(String code,LocalDate dob) {
		return repository.loginStudent(code, dob);
	}
	
}
