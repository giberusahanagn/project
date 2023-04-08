package com.xworkz.sahana.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xworkz.sahana.configuration.ArmyConfiguration;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class Runner {
	public static void main(String[] args) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/anything", "root",
					"Xworkzodc@123");
			String sql = "select * from Army_table ";
			  Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int id = resultSet.getInt("t_id");
				String name = resultSet.getString("t_name");
				String country = resultSet.getString("t_country");
				int age = resultSet.getInt("t_age");
				int punishment = resultSet.getInt("t_punishment");

				log.info(id+" name "+name+" Country "+country+" age "+age+" punishment "+punishment);;
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}

	
	
}
