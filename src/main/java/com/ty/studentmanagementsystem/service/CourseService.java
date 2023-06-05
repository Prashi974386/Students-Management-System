package com.ty.studentmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.studentmanagementsystem.dao.CourseDao;
import com.ty.studentmanagementsystem.dto.Course;
import com.ty.studentmanagementsystem.dto.ResponseStructure;
import com.ty.studentmanagementsystem.dto.Student;

@Service
public class CourseService {
	@Autowired
	CourseDao dao;
	
	public ResponseStructure<Course> saveCourse(Course course) {
		ResponseStructure<Course> responseStructure = new ResponseStructure<Course>();
		if(course != null) {
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("Data Stored");
			responseStructure.setData(dao.saveCourse(course));
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Plz try onr more time");
			responseStructure.setData(null);
		}
		return responseStructure;
	}
	
	public ResponseStructure<List<Student>> getStudentByCourse(int id){
		ResponseStructure<List<Student>> responseStructure = new ResponseStructure<List<Student>>();
		
		Course courses = dao.getCourseById(id); 
		if(courses != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("All the Students Details By Courses");
			responseStructure.setData(courses.getStudents());
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Plz check the Courses");
			responseStructure.setData(null);
		}
		return responseStructure;
	}
	
	public ResponseStructure<Course> leaveCourse(int id,String code) {
		ResponseStructure<Course> responseStructure = new ResponseStructure<Course>();
		Course course = dao.leaveCourse(id,code);
		if(course != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Leaved Courses Successfully");
			responseStructure.setData(course);
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Plz try One more time");
			responseStructure.setData(null);
		}
		return responseStructure;
	}
}
