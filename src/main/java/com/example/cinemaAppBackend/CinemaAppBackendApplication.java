package com.example.cinemaAppBackend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class CinemaAppBackendApplication {

	//private final JdbcTemplate jdbcTemplate;
	public static void main(String[] args) {
		SpringApplication.run(CinemaAppBackendApplication.class, args);
	}
}
