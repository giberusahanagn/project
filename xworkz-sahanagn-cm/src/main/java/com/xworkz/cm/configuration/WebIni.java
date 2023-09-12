package com.xworkz.cm.configuration;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.sun.tools.sjavac.Log;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebIni extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {

	private int maxUploadSizeInMb = 10 * 1024 * 1024;

	@Override
	protected Class<?>[] getRootConfigClasses() {
		log.info("running getRootConfigClasses");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		log.info("running getServletConfigClasses");
		return new Class[] { ProjectConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		log.info("running getServletMappings");
		return new String[] { "/" };
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		log.info("running configureDefaultServletHandling");
		configurer.enable();
	}

	@Override
	protected void customizeRegistration(Dynamic registration) {
		log.info("customizeRegistration");
		String temDir = "";
		File uploadDirectory = new File(System.getProperty("java.io.tmpdir"));
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(uploadDirectory.getPath(), maxUploadSizeInMb, maxUploadSizeInMb*2, maxUploadSizeInMb/2);
		registration.setMultipartConfig(multipartConfigElement);
	}
}
