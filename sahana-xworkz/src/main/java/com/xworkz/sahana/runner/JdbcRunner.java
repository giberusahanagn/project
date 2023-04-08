package com.xworkz.sahana.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.xworkz.sahana.configuration.ArmyConfiguration;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class JdbcRunner {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/anything", "root",
					"Xworkzodc@123");
			String insertQuery = "insert into Army_table (t_name,t_country,t_age,t_punishment) values('abdul','pakisthan',23,77)";
			Statement statement = connection.createStatement();

			int rowsAffected = statement.executeUpdate(insertQuery);
			log.info("rowsAffected..." + rowsAffected);
			connection.close();
		} catch (ClassNotFoundException e) {

			System.err.println("ClassNotFoundException problem loading the driver");
		} catch (SQLException e) {
			System.err.println("SqlException connecting to db....");
		}
	}
}
