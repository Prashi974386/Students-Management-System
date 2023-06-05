package com.ty.studentmanagementsystem.daotesting;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ty.studentmanagementsystem.dto.Student;
import com.ty.studentmanagementsystem.repository.StudentRepository;

@SpringBootTest
public class StudentDaoTest {
	@Autowired
	StudentRepository repository;
	
	@Test
	public void saveStudnet() {
		Student student = Student.builder()
				.name("rahul")
				.gender("male")
				.dob(LocalDate.of(2023, 12, 12))
				.build();
		
		repository.save(student);
		
		Assertions.assertThat(student.getId()).isGreaterThan(0);
		
	}
	
	@Test
	public void updateStudnet() {
		Student student = Student.builder()
				.unique_student_code("rah1002")
				.email("rahul@gmail.com")
				.phone(8765432190l)
				.p_name("asd")
				.build();
		
		repository.save(student);
		
		Assertions.assertThat(student.getId()).isGreaterThan(0);
		
	}
	
	@Test
	public void getStudentByName() {
		Assertions.assertThat(repository.getStudentsByName("rani")).isNotEmpty();
	}
	
	@Test
	public void getStudentByUniqe() {
		Assertions.assertThat(repository.getStudentsByCode("ran1001")).isNotNull();
	}
	
	@Test
	public void login() {
		Assertions.assertThat(repository.loginStudent("ran1001",LocalDate.of(1995,03,12)).getId()).isGreaterThan(0);
	}
}
