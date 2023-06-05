package com.ty.studentmanagementsystem.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String unique_student_code;
	private String name;
	private String gender;
	@JsonFormat(pattern = "dd/MM/yyyy") 
	private LocalDate dob;
	@Column(unique = true)
	private String email;
	private long phone;
	private String p_name;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "student")
	private List<Address> address;
	
	@ManyToMany
	@JoinTable
	@JsonIgnore
	private List<Course> courses;
	
}
