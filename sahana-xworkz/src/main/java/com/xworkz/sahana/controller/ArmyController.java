package com.xworkz.sahana.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.sahana.configuration.ArmyConfiguration;
import com.xworkz.sahana.dto.ArmyDTO;
import com.xworkz.sahana.service.ArmyService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping
@Slf4j
public class ArmyController {

	@Autowired
	private ArmyService service;

	public ArmyController() {
		log.info("running " + this.getClass().getSimpleName());
	}

	@GetMapping("/army")
	public String onArmy(Model model) {
		log.info(" onArmy getmapping");
		return "Army";
	}

	@PostMapping("/army")
	public String onArmy(Model model, ArmyDTO dto) {
		log.info("running onArmy in Controller.... - postmapping");

		Set<ConstraintViolation<ArmyDTO>> violations = service.saveAndValidate(dto);
		if (violations.isEmpty()) {
			log.info("data is saved " + dto);
			model.addAttribute("dto", dto);
			return "ArmySuccess";
		} else {
			model.addAttribute("errors", violations);
			model.addAttribute("dto", dto);
			model.addAttribute("message", "data is not saved");
			return "Army";
		}
	}

	@PostMapping("/search")
	public String serachById(@RequestParam int id, Model model) {
		log.info("running Search method...");
		ArmyDTO dto = this.service.findById(id);
		if (dto != null) {
			model.addAttribute("dto", dto);
		} else {
			model.addAttribute("display", "data not found");
		}
		return "ArmySearch";
	}

	@GetMapping("/searchByCountry")
	public String searchByCountry(@RequestParam String country, Model model) {
		log.info("running searchByCountry method in controller");
		List<ArmyDTO> list = this.service.findByCountry(country);
		model.addAttribute("dtos", list);
		return "CountrySearch";
	}

	@GetMapping("/update")
	public String onUpdate(@RequestParam int id, Model model) {
		log.info("running Search method...");
		ArmyDTO dto = this.service.findById(id);
		if (dto != null) {
			model.addAttribute("dto", dto);
		} else {
			model.addAttribute("display", "data not found");

		}
		return "UpdateArmy";
	}

	@PostMapping("/update")
	public String onUpdate(Model model, ArmyDTO dto) {
		log.info("running Post method of ONUPDATE...");
		Set<ConstraintViolation<ArmyDTO>> violations = this.service.validateAndUpdate(dto);
		if (violations.size() > 0) {
			System.err.println("violations in update....");
			model.addAttribute("errors", violations);

		} else {
			log.info("data is good can be update...");
			model.addAttribute("message", "update is success");
		}
		return "UpdateArmy";
	}

	@GetMapping("/delete")
	public String onDelete(@RequestParam int id, Model model) {
		log.info("running delete method..." + id);
		boolean delete = this.service.validateAndDelete(id);
		log.info("deleted...." + delete);
		model.addAttribute("data", "data delete successfully");
		return "DeleteArmy";
	}

}
