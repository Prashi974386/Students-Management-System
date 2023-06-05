package com.ty.studentmanagementsystem.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ty.studentmanagementsystem.dto.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{
	@Query("select a from Student a where name=:name")
	public List<Student> getStudentsByName(@RequestParam String name);
	
	@Query("select a from Student a where unique_student_code=:code")
	public Student getStudentsByCode(@RequestParam String code);
	
	@Query("select a from Student a where unique_student_code=:code and dob=:dob")
	public Student loginStudent(@RequestParam String code,@RequestParam LocalDate dob);
}
