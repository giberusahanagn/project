package com.xworkz.cm.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.cm.dto.SignUpDto;
import com.xworkz.cm.entity.SignUpEntity;

public interface ProjectService {

	Set<ConstraintViolation<SignUpDto>> validateAndSave(SignUpDto dto);

	Integer checkDuplicates(String userId, String email, long mobile);

	boolean sendMail(String email, String message);

	Map<String, SignUpDto> signIn(String userId, String password);

	default String resetPwd(String email) {
		return null;
	}
	default SignUpDto findByuserId(String userId ) {
		return null;
	}
	
	default SignUpDto findByEmail(String email ) {
		return null;
	}


	default String updatePwd(String userId, String password, boolean resetPwd) {
		return null;
	}
	Set<ConstraintViolation<SignUpDto>> validateAndUpdateProfile(SignUpDto dto);



}
