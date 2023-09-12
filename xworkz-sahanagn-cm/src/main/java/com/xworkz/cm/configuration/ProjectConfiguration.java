package com.xworkz.cm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import lombok.extern.slf4j.Slf4j;

@ComponentScan("com.xworkz.cm")
@Configuration
@Slf4j
public class ProjectConfiguration {

	public ProjectConfiguration() {
		log.info("create " + this.getClass().getSimpleName());
	}

	@Bean
	public MultipartResolver multipartResolver() {
		log.info("registering multipartResolver");
		return new StandardServletMultipartResolver();

	}

	@Bean
	public ViewResolver viewResolver() {
		log.info("running viewResolver ");
		return new InternalResourceViewResolver("/", ".jsp");
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
		log.info("running localContainerEntityManagerFactoryBean");
		return new LocalContainerEntityManagerFactoryBean();

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		log.info("Registering the PasswordEncoder");
		return new BCryptPasswordEncoder(10);
	}
}
