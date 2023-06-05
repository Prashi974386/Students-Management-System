package com.ty.studentmanagementsystem.daotesting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ty.studentmanagementsystem.dto.Admin;
import com.ty.studentmanagementsystem.dto.Login;
import com.ty.studentmanagementsystem.repository.AdminRepository;

@SpringBootTest
public class AdminDaoTest {
	
	@Autowired
	AdminRepository repository;
	
	@Test
	public void saveAdmin() {
		Admin admin = Admin.builder()
				.name("ramu")
				.email("ramu@gmail.com")
				.phone(9876543211l)
				.password("ramu123")
				.build();
		
		repository.save(admin);
		
		Assertions.assertThat(admin.getId()).isGreaterThan(0);
	}
	
	@Test
	public void loginAdmin() {
		 Admin admin = repository.loginAdmin("ramu@gmail.com", "ramu123");
		  
		 Assertions.assertThat(admin.getId()).isGreaterThan(0);
	}
}
