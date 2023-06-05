package com.ty.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.studentmanagementsystem.dto.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}
