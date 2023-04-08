package com.xworkz.sahana.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name = "terrorist_table")
@NamedQuery(name = "findByCountry",query = "select entity from ArmyEntity entity where entity.country=:country ")

public class ArmyEntity {

	@Id
	@Column(name = "t_id")
	private int id;

	@Column(name = "t_name")
	private String name;

	@Column(name = "t_country")
	private String country;

	@Column(name = "t_age")
	private Integer age;

	@Column(name = "t_punishment")
	private Integer punishment;
}
