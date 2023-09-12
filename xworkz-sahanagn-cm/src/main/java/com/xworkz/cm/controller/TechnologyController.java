package com.xworkz.cm.controller;

import java.util.Arrays;
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

import com.xworkz.cm.dto.TechnologyDto;
import com.xworkz.cm.service.TechnologyService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/")
public class TechnologyController {
	@Autowired
	private TechnologyService service;

	private List<String> OStype = Arrays.asList("MS-Windows", "Ubuntu", "Mac OS", "Fedora", "Solaris", "Free BSD",
			"Chrome OS", "CentOS", "Debian", "Deepin", "Linux");

	public TechnologyController() {
		log.info("Running in technology controller");
	}

	@GetMapping("/addTechnology")
	public String onAddTech(Model model) {
		model.addAttribute("OStype", OStype);
		return "AddTechnology";
	}

	@PostMapping("/addTechnology")
	public String onAddList(String userId, TechnologyDto technology, Model model) {
		log.info("running onAddList");
		Set<ConstraintViolation<TechnologyDto>> violations = this.service.validateAndAdd(technology);
		if (violations.isEmpty()) {
			log.info("There is no violations can add a technology");
			model.addAttribute("OStype", OStype);
			model.addAttribute("addTechSuccess", "Successfully added the technology : " + technology.getName());
			return "AddTechnology";
		}
		log.info("Violations in the technology, can't add it");
		model.addAttribute("errors", violations);
		model.addAttribute("OStype", OStype);
		model.addAttribute("errors", "Violations in the technology, can't add it");
		return "AddTechnology";
	}

	@GetMapping("/view")
	public String onKnownTechnology(Model model) {
		log.info("fetching all KnownTechnology");
		List<TechnologyDto> list = this.service.viewTechnology();
		if (list != null) {
			model.addAttribute("list", list);
		}
		return "KnownTechnology";

	}

	@GetMapping("/searchByKeyword")
	public String onSearchByKeyword(@RequestParam String keyword, Model model) {
		log.info("running onSearchName controller " + keyword);
		List<TechnologyDto> list = this.service.searchByKeyword(keyword);
		model.addAttribute("list", list);
		return "KnownTechnology";

	}
}
