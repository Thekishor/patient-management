package com.auth_service;

import com.auth_service.Config.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AuthServiceApplication {

	public static void main(String[] args) {
		 SpringApplication.run(AuthServiceApplication.class, args);
		/*ApplicationContext context = SpringApplication.run(AuthServiceApplication.class, args);
		*//*SecurityConfig securityConfig = context.getBean(SecurityConfig.class);
		securityConfig.passwordEncoder();*/
	}

}
