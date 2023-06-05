package com.ty.studentmanagementsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.studentmanagementsystem.dto.Course;
import com.ty.studentmanagementsystem.dto.Student;
import com.ty.studentmanagementsystem.repository.CourseRepository;
import com.ty.studentmanagementsystem.repository.StudentRepository;
@Repository
public class CourseDao {
	@Autowired
	CourseRepository repository;
	@Autowired
	StudentDao dao;
	
	public Course saveCourse(Course course) {
		return repository.save(course);
	}
	
	public Course getCourseById(int id) {
		Optional<Course> optional = repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public Course leaveCourse(int id,String code) {
		Optional<Course> optional = repository.findById(id);
		if(optional.isPresent()) {
			Student student = dao.getStudentByUique(code);
			List<Course> list = student.getCourses();
			list.remove(optional.get());
			
			student.setCourses(list);
			dao.updateStudent(student);
		}
		return optional.get();
	}
}
