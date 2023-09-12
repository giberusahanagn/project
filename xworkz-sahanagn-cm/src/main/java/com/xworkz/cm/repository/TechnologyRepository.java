package com.xworkz.cm.repository;

import java.util.Collections;
import java.util.List;

import com.xworkz.cm.dto.TechnologyDto;
import com.xworkz.cm.entity.TechnolgyListEntity;

public interface TechnologyRepository {
	
	boolean add(TechnolgyListEntity entity);
	
	default List<TechnolgyListEntity> viewTechnology(){
		return Collections.emptyList();
	}
	default List<TechnolgyListEntity> searchByKeyword(String keyword) {
		return Collections.emptyList();
	}


}
