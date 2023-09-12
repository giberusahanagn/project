package com.xworkz.cm.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data

public class SignUpDto {

	@NotNull
	@Size(min = 2, max = 20, message = "userId should be greater than 3 less than 20")
	private String userId;
	@NotNull
	@Email
	@Size(min = 6, max = 30, message = "Email should be greater than 6 less than 20")
	private String email;
	@NotNull
	@Min(value = 6000000000l, message = "The number should start with 6 and must contain 10 digits ")
	@Max(value = 9999999999l, message = "The number should start with 6 and must contain 10 digits ")
	private long mobile;
	@NotNull(message = "Password can't be null")
	//@Size(min = 5, max = 30, message = "password should be greater than 5 less than 20")
	private String password;
	private String createdBy;
	private LocalDateTime createdDate = LocalDateTime.now();
	private String updateBy;
	private LocalDateTime updatedDate;	
	private LocalTime otpRequestedTime;
	private String profilePic;



}
