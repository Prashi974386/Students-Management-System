package com.ty.studentmanagementsystem.daotesting;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ty.studentmanagementsystem.dto.Course;
import com.ty.studentmanagementsystem.repository.CourseRepository;

@SpringBootTest
public class CourseDaoTest {
	@Autowired
	CourseRepository repository;
	
	@Test
	public void saveCourse() {
		String[] str = {"html","css"};
		
		Course course = Course.builder()
				.name("python full stack")
				.description("hello")
				.coursetype("short")
				.durationMonth(5)
				.topics(str)
				.build();
		
		repository.save(course);
		
		Assertions.assertThat(course.getId()).isGreaterThan(0);
	}
	
	@Test
	public void getCourseById() {
		Assertions.assertThat(repository.findById(2).get()).isNotNull();
	}
	
}
