package com.xworkz.sahana.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import lombok.extern.slf4j.Slf4j;

@Configuration
@ComponentScan("com.xworkz.sahana")
@Slf4j
public class ArmyConfiguration {

	public ArmyConfiguration() {
		log.info("running " + this.getClass().getSimpleName());
		log.info("printing msg in loggers");
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean bean() {
		log.info("registering LocalContainerEntityManagerFactoryBean");
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		return bean;
	}

	
	@Bean
	public MultipartResolver multipartResolver() {
		log.info("registering multipartResolver");
		return new StandardServletMultipartResolver();
	}

	@Bean
	public ViewResolver resolver() {
		log.info("registering ViewResolverResolver");
		return new InternalResourceViewResolver("/", ".jsp");
	}

}