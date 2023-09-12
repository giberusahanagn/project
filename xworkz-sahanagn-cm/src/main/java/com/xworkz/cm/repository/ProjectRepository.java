package com.xworkz.cm.repository;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import com.xworkz.cm.entity.SignUpEntity;

public interface ProjectRepository {

	boolean save(SignUpEntity entity);

	Integer checkDuplicates(String userId, String email, long mobile);

	default List<SignUpEntity> signIn(String userId) {
		return Collections.emptyList();

	}

	boolean updateWrongLoginAttempts(String userId, int lockCount);

	default List<SignUpEntity> findByEmail(String email) {
		return Collections.emptyList();
	}
	
	default SignUpEntity findByuserId(String userId ) {
		return null;
	}
	
	default SignUpEntity entityByEmail(String email ) {
		return null;
	}

	boolean updateResetPwd(String email, boolean resetPwd, String password);

	boolean updateConfirmPwd(String userId, boolean resetPwd, String password);
	
	boolean updateProfile(SignUpEntity entity);
	
	//boolean otpRequestedTimePwd(String userId, String password,boolean resetPwd,LocalTime otpRequestedTime);


}
