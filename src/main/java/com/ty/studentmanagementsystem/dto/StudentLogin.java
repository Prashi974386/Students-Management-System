package com.ty.studentmanagementsystem.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentLogin {
	private String unique_student_code;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dob;
	
}
