package com.xworkz.sahana.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.dbcp.dbcp2.Utils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.sahana.configuration.ArmyConfiguration;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class ImageController {

	public ImageController() {
		log.info("running " + this.getClass().getSimpleName());
	}

	@PostMapping("/upload")
	public String onUpload(@RequestParam("chitra") MultipartFile file) throws IOException {
		log.info("running onUpload postMapping...");
		log.info("multipart..." + file);
		log.info(file.getContentType());

		byte[] bytes = file.getBytes();
		Path path = Paths.get("D:\\java\\git\\army-file\\" + file.getOriginalFilename());
		Files.write(path, bytes);
		return "ImageUpload";
	}

	@GetMapping("/download")
	public String onDownload(HttpServletResponse response, @RequestParam String fileName)
			throws IOException {
		response.setContentType("image/jpeg");
		File file = new File("D:\\java\\git\\army-file" + fileName);
		InputStream in = new BufferedInputStream(new FileInputStream(file));
		ServletOutputStream out = response.getOutputStream();
		IOUtils.copy(in, out);
		response.flushBuffer();
		return "ImageDownload";
	}
}
