package com.xworkz.sahana.service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.sahana.dto.ArmyDTO;

public interface ArmyService {

	Set<ConstraintViolation<ArmyDTO>> saveAndValidate(ArmyDTO dto);

	default ArmyDTO findById(int id) {
		return null;
	}

	default List<ArmyDTO> findByCountry(String country) {
		return Collections.emptyList();
	}

	Set<ConstraintViolation<ArmyDTO>> validateAndUpdate(ArmyDTO dto);

	boolean validateAndDelete(int id);
}
