package com.securityinternal.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MyappApplication //extends SpringBootServletInitializer
{

	public static void main(String[] args) {
		SpringApplication.run(MyappApplication.class, args);
	}

}
