package com.xworkz.sahana.configuration;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArmyWebInit extends AbstractAnnotationConfigDispatcherServletInitializer
		implements WebMvcConfigurer {

	public ArmyWebInit() {
		log.info("running " + this.getClass().getSimpleName());
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		log.info("running getRootConfigClasses");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		log.info("running getServletConfigClasses");
		return new Class[] { ArmyConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		log.info("running getServletMappings ");
		return new String[] { "/" };
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		log.info("running enable method...");
		configurer.enable();
	}

	@Override
	protected void customizeRegistration(Dynamic registration) {
		String tempDir = "D:\\java\\git\\files";
		int maxUploadSizeInMb = 6 * 1024 * 1024;
		File uploadDirectory = new File(tempDir);
		MultipartConfigElement element = new MultipartConfigElement(uploadDirectory.getAbsolutePath(),
				maxUploadSizeInMb, maxUploadSizeInMb * 2, maxUploadSizeInMb / 2);
		registration.setMultipartConfig(element);

	}
}
