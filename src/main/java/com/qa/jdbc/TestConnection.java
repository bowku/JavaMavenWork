package com.qa.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestConnection {

	public static final Logger LOGGER = LogManager.getLogger(); // final means never change

	private String connectionURL = "jdbc:mysql://localhost:3306/persondb";
	private String username = "root";
	private String password = "pass";

	public void testConnection() {

		Connection conn = null;

		LOGGER.info("Attempting DB connection...");
		try {
			System.out.println("Attempting DB connection...");
			conn = DriverManager.getConnection(connectionURL, username, password);
			System.out.println("Connected to Database");
		} catch (SQLException se) {
			LOGGER.error(se.getMessage());
		} finally {
			try {
				if (conn != null) {

					conn.close();
				}
			} catch (SQLException e) {
				LOGGER.error(e);
			}
		}

	}

}
