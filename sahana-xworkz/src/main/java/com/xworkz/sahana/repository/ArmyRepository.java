package com.xworkz.sahana.repository;

import java.util.Collections;
import java.util.List;

import com.xworkz.sahana.dto.ArmyDTO;
import com.xworkz.sahana.entity.ArmyEntity;

public interface ArmyRepository {

	boolean save(ArmyEntity entity);

	public default ArmyEntity findById(int id) {

		return null;
	}

	public default List<ArmyEntity> searchByCountry(String country) {

		return Collections.emptyList();
	}

	boolean update(ArmyEntity entity);
	
	boolean delete(int id);
}
