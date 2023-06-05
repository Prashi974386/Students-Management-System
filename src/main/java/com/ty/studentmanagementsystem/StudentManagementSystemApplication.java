package com.ty.studentmanagementsystem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class StudentManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	List<VendorExtension> extensions = new ArrayList<VendorExtension>();
	Contact contact = new Contact("Prashanth", "http://platformcommons.com", "prashantha2607@gmail.com");
	ApiInfo info = new ApiInfo("Student Management System",
			"This Project is helps to Create Students and Add the courses into particuler students", "snapchat-0.01",
			"http://platformcommons.com", contact, "www.pc.com", "terms an condition", extensions);

	@Bean
	public Docket myDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ty.studentmanagementsystem")).build().apiInfo(info);
	}

}
