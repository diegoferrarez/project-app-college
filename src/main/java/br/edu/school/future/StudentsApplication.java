package br.edu.school.future;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class StudentsApplication {
	public static void main(String[] args) {
		SpringApplication.run(StudentsApplication.class, args);
	}

}
