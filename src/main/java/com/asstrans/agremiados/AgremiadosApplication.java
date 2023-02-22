package com.asstrans.agremiados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication
public class AgremiadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgremiadosApplication.class, args);
	}

}
