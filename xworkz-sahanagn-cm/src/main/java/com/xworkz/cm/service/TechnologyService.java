package com.xworkz.cm.service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.cm.dto.TechnologyDto;

public interface TechnologyService {

	
	Set<ConstraintViolation<TechnologyDto>> validateAndAdd(TechnologyDto dto);
	
	default List<TechnologyDto> viewTechnology(){
		return Collections.emptyList();
	}
    
	default List<TechnologyDto> searchByKeyword(String keyword) {
		return Collections.emptyList();
	}

}
