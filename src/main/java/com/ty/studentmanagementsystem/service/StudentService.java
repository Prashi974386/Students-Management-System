package com.ty.studentmanagementsystem.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.studentmanagementsystem.dao.AddressDao;
import com.ty.studentmanagementsystem.dao.CourseDao;
import com.ty.studentmanagementsystem.dao.StudentDao;
import com.ty.studentmanagementsystem.dto.Course;
import com.ty.studentmanagementsystem.dto.ResponseStructure;
import com.ty.studentmanagementsystem.dto.Student;
import com.ty.studentmanagementsystem.dto.StudentLogin;

@Service
public class StudentService {
	@Autowired
	StudentDao dao;
	@Autowired
	CourseDao courseDao;

	public ResponseStructure<Student> saveStudent(Student student) {
		ResponseStructure<Student> responseStructure = new ResponseStructure<Student>();
		Student student2 = dao.saveStudent(student);
		if (student2 != null) {
			String name = student2.getName();
			String uname = "";
			for (int i = 0; i < name.length(); i++) {
				if (i < 3) {
					uname += name.charAt(i);
				}
			}
			
			student2.setUnique_student_code(uname + (1000 + student2.getId()));
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMsg("Data Success");
			responseStructure.setData(dao.saveStudent(student2));
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Plz try onr more time");
			responseStructure.setData(null);
		}
		return responseStructure;
	}

	public ResponseStructure<Student> updateStudent(Student student) {
		ResponseStructure<Student> responseStructure = new ResponseStructure<Student>();
		if(student != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Updated success");
			responseStructure.setData(dao.updateStudent(student));
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Plz try onr more time");
			responseStructure.setData(null);
		}
		return responseStructure;
	}

	public ResponseStructure<Student> assignCourses(String uniqcode, int cid) {
		ResponseStructure<Student> responseStructure = new ResponseStructure<Student>();
		Student student = dao.getStudentByUique(uniqcode);
		Course course = courseDao.getCourseById(cid);
		
		if (student != null && course != null) {
			List<Course> list = student.getCourses();
			list.add(course);
			student.setCourses(list);
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("updated Success");
			responseStructure.setData(dao.updateStudent(student));
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Plz try onr more time");
			responseStructure.setData(null);
		}
		return responseStructure;
	}

	public ResponseStructure<List<Student>> getStudentsByName(String name) {
		ResponseStructure<List<Student>> responseStructure = new ResponseStructure<List<Student>>();
		List<Student> list = dao.getStudentsByName(name);
		if (list.isEmpty()) {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Students details is not found");
			responseStructure.setData(null);
		} else {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("All Students Details");
			responseStructure.setData(list);
		}
		return responseStructure;
	}

	public ResponseStructure<List<Course>> getCoursesByStudent(String uniqecode) {
		ResponseStructure<List<Course>> responseStructure = new ResponseStructure<List<Course>>();
		Student student = dao.getStudentByUique(uniqecode);
		if (student != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("All Courses Details choosen By Student");
			responseStructure.setData(student.getCourses());
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Students details is not found");
			responseStructure.setData(null);
		}
		return responseStructure;
	}
	
	public ResponseStructure<Student> loginStudent(StudentLogin login) {
		ResponseStructure<Student> responseStructure = new ResponseStructure<Student>();
		if(login != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Login Success");
			responseStructure.setData(dao.loginStudent(login.getUnique_student_code(), login.getDob()));
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Login UnSuccess");
			responseStructure.setData(null);
		}
		return responseStructure;
		
	}
}
