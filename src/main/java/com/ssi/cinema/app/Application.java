package com.ssi.cinema.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ssi.cinema.app.security.SecurityConfig;
import com.ssi.cinema.backend.UserRepository;
import com.ssi.cinema.backend.data.entity.User;
import com.ssi.cinema.backend.service.UserService;
import com.ssi.cinema.backend.util.LocalDateJpaConverter;

@SpringBootApplication(scanBasePackageClasses = { Application.class, UserService.class,
		SecurityConfig.class })
@EnableJpaRepositories(basePackageClasses = { UserRepository.class })
@EntityScan(basePackageClasses = { User.class, LocalDateJpaConverter.class })
public class Application extends SpringBootServletInitializer {
	
	public static final String APP_URL = "/";
	
	public static final String LOGIN_URL = "/login";
	
	public static final String LOGOUT_URL = "/welcome";
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
}
