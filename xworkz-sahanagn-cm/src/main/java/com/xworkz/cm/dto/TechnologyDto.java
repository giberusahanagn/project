package com.xworkz.cm.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TechnologyDto {
	private int id;
	
	@NotEmpty(message= "Name can't be null")
	@Size(min=2 ,max=14 ,message="name should be less than 2 grether than 14")
	private String name;
	
	@NotEmpty(message = "Language can't be null")
	private String language;
	
	@NotEmpty(message = "Version can't be null")
	private String version;
	
	@NotEmpty(message = "Owner can't be null")
	private String owner;
	@NotEmpty(message = "Support From can't be null")
	private String supportFrom;
	
	@NotEmpty(message = "Support To can't be null")
	private String supportTo;
	
	@NotEmpty(message = "License can't be null")
	private String license;
	
	
	@NotNull(message = "OS Type can't be null")
	private String osType;
	
	@NotNull(message = "openSource can't be null")
	private Boolean openSource;


}
