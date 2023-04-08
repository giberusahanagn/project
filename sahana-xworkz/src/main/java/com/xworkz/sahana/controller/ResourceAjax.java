package com.xworkz.sahana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.xworkz.sahana.dto.ArmyDTO;
import com.xworkz.sahana.service.ArmyService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@EnableWebMvc
@RequestMapping("/")
public class ResourceAjax {
	@Autowired
	private ArmyService armyService;

	public ResourceAjax() {
		log.info("running " + this.getClass().getSimpleName());
	}
	
	@GetMapping(value = "/call",produces = MediaType.APPLICATION_JSON_VALUE)
	public String onCall() {
		log.info("running onCall in FirstResource");
		return "This is the data returned now ,for practise...";
		
	}

	@GetMapping(value= "/dto/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ArmyDTO onDto(@PathVariable int id) {
		log.info("running ArmyDTO with id "+id);
		ArmyDTO dto=armyService.findById(id);
		return dto;
	}
}

