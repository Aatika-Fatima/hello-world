package com.example.passport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.example.passport.repository")
public class SpringPassportAatikaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPassportAatikaApplication.class, args);
	}
}
