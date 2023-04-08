package com.xworkz.sahana.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ArmyDTO {

	private int id;

	@NotNull(message = "name not be blank")
	private String name;

	@NotNull(message = "country not be blank")
	private String country;
	
	@NotNull(message = "age not be null")
	private int age;
	
	@NotNull(message = "punishment not be null")
	private int punishment;
}
