package com.xworkz.sahana.service;

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

import com.xworkz.sahana.configuration.ArmyConfiguration;
import com.xworkz.sahana.dto.ArmyDTO;
import com.xworkz.sahana.entity.ArmyEntity;
import com.xworkz.sahana.repository.ArmyRepository;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ArmyServiceImpl implements ArmyService {

	@Autowired
	private ArmyRepository repository;

	public ArmyServiceImpl() {
		log.info("running " + this.getClass().getSimpleName());
	}

	@Override
	public Set<ConstraintViolation<ArmyDTO>> saveAndValidate(ArmyDTO dto) {
		log.info("running saveAndValidate" + dto);
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<ArmyDTO>> violations = validator.validate(dto);
		if (violations != null && !violations.isEmpty()) {
			System.err.println("violations in data is cannot save");
			violations.forEach(e -> log.info(e.getMessage()));
			return violations;
		} else {
			log.info("No violations in data can be saved");
			ArmyEntity entity = new ArmyEntity();
//			entity.setName(dto.getName());
//			entity.setCountry(dto.getCountry());
//			entity.setAge(dto.getAge());
//			entity.setPunishment(dto.getPunishment());
			BeanUtils.copyProperties(dto, entity);
			Boolean saved = repository.save(entity);
			log.info("data saved... " + saved);
			return Collections.emptySet();
		}

	}

	@Override
	public ArmyDTO findById(int id) {
		log.info("overriding find by id method...");
		if (id > 0) {
			ArmyEntity entity = this.repository.findById(id);
			if (entity != null) {
				log.info("entity/data found from database");
				ArmyDTO dto = new ArmyDTO();
				dto.setName(entity.getName());
				dto.setCountry(entity.getCountry());
				dto.setAge(entity.getAge());
				dto.setPunishment(entity.getPunishment());
				dto.setId(entity.getId());
				return dto;
			} else {
				System.err.println("data not found for id :" + id);

			}
		} 
		return null;
	}

	@Override
	public List<ArmyDTO> findByCountry(String country) {
		log.info("running findByCountry..." + country);

		if (country != null && !country.isEmpty()) {
			log.info("data is valid call repo... ");

			List<ArmyEntity> entities = this.repository.searchByCountry(country);
			List<ArmyDTO> ArmyDtos = new ArrayList<>();

			for (ArmyEntity entity : entities) {
				ArmyDTO dto = new ArmyDTO();
				dto.setId(entity.getId());
				dto.setName(entity.getName());
				dto.setCountry(entity.getCountry());
				dto.setAge(entity.getAge());
				dto.setPunishment(entity.getPunishment());

				ArmyDtos.add(dto);

			}
			log.info("size of Entities..." + entities.size());
			log.info("size of Dtos..." + ArmyDtos.size());
			return ArmyDtos;
		} else {
			System.err.println("country not found or invalid");
			return Collections.emptyList();
		}
	}

	@Override
	public Set<ConstraintViolation<ArmyDTO>> validateAndUpdate(ArmyDTO dto) {
		log.info("running validate and update...." + dto);
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<ArmyDTO>> violations = validator.validate(dto);
		if (violations != null && !violations.isEmpty()) {
			System.err.println("violations in data is cannot save");
			violations.forEach(e -> log.info(e.getMessage()));
			return violations;
		} else {
			log.info("No violations in data can be saved");
			ArmyEntity entity = new ArmyEntity();
			entity.setName(dto.getName());
			
			entity.setAge(dto.getAge());
			entity.setPunishment(dto.getPunishment());
		
			Boolean saved = repository.update(entity);
			log.info("data saved... " + saved);
			return Collections.emptySet();

		}
	}

	@Override
	public boolean validateAndDelete(int id) {
		log.info("running delete in service impl...." + id);
		if (id > 0) {
			log.info("data found for delete...");
			boolean deleted = this.repository.delete(id);
			log.info("deleted.."+deleted);
			return true;
		}
		return false;
	}
}
