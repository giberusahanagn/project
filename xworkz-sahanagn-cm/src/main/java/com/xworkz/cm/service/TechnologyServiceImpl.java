package com.xworkz.cm.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.cm.dto.TechnologyDto;
import com.xworkz.cm.entity.TechnolgyListEntity;
import com.xworkz.cm.repository.TechnologyRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TechnologyServiceImpl implements TechnologyService {

	@Autowired
	private TechnologyRepository technologyRepository;

	@Override
	public Set<ConstraintViolation<TechnologyDto>> validateAndAdd(TechnologyDto dto) {
		log.info("validateAndAdd in TechnologyServiceImpl");

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<TechnologyDto>> violations = validator.validate(dto);
		violations.forEach(a -> System.out.println(a));
		if (violations != null && !violations.isEmpty()) {
			log.info("Violations in dto" + dto);
			return violations;
		}
		TechnolgyListEntity entity = new TechnolgyListEntity();
		BeanUtils.copyProperties(dto, entity);
		boolean add = this.technologyRepository.add(entity);
		if (add) {
			log.info("Technology added successfully" + entity);
		}
		return Collections.emptySet();
	}

	@Override
	public List<TechnologyDto> viewTechnology() {
		List<TechnolgyListEntity> entities = this.technologyRepository.viewTechnology();
		List<TechnologyDto> listOfDto = new ArrayList<TechnologyDto>();
		for (TechnolgyListEntity entity : entities) {
			TechnologyDto dto = new TechnologyDto();
			BeanUtils.copyProperties(entity, dto);
			listOfDto.add(dto);

		}
		log.info("size of dtos" + listOfDto.size());
		log.info("size of entities" + entities.size());
		return listOfDto;
	}

	@Override
	public List<TechnologyDto> searchByKeyword(String keyword) {
			log.info("running searchByKeyword is service.." + keyword);
			if (keyword != null && !keyword.isEmpty()) {
				log.info("keyword is Valid... calling repo...");
				List<TechnolgyListEntity> entities = this.technologyRepository.searchByKeyword(keyword);
				List<TechnologyDto> listOfDto = new ArrayList<TechnologyDto>();
				for (TechnolgyListEntity entity : entities) {
					TechnologyDto dto = new TechnologyDto();
					BeanUtils.copyProperties(entity, dto);
					listOfDto.add(dto);

				}
				log.info("size of dtos" + listOfDto.size());
				log.info("size of entities" + entities.size());
				return listOfDto;
			} else {
				System.err.println("keyword is Invalid");
			}

		return TechnologyService.super.searchByKeyword(keyword);
	}
}
