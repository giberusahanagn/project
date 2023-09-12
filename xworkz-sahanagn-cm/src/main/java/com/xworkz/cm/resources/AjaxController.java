package com.xworkz.cm.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.xworkz.cm.service.ProjectService;

import lombok.extern.slf4j.Slf4j;

@EnableWebMvc
@RestController
@Slf4j
@RequestMapping("/")
public class AjaxController {

	@Autowired
	private ProjectService service;

	public AjaxController() {
		log.info("create " + this.getClass().getSimpleName());
	}

	@GetMapping(value = "/userId/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String findByUserId(@PathVariable String userId) {
		log.info("running ajax findByUserId");
		int count = this.service.checkDuplicates(userId, null, 0);
		System.out.println(count);

		if (count == 0) {
			log.info("Running in equals condition");
			return "";
		} else {
			return "UserId exsist";
		}
	}

	@GetMapping(value = "/email/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String findByEmail(@PathVariable String email) {
		log.info("running ajax findByEmail");
		int count = this.service.checkDuplicates(null, email, 0);
		System.err.println(count);

		if (count == 0) {
			log.info("Running in equals condition");
			return "";
		} else {
			return "Email is exsist";
		}
	}

	@GetMapping(value = "/mobile/{mobile}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String findByMobileNo(@PathVariable long mobile) {
		log.info("running ajax findByMobileNo");
		int count = this.service.checkDuplicates(null, null, mobile);
		System.err.println(count);

		if (count == 0) {
			log.info("Running in equals condition");
			return "";
		} else {
			return "Mobile number is exsist";
		}
	}
}
