package com.qa.jdbc.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.jdbc.domain.Person; //because its different package so we need to import

public class PersonDAO implements Dao<Person>{

	public static final Logger LOGGER = LogManager.getLogger();

	// Three things we need to connect

	private String connectionURL = "jdbc:mysql://localhost:3306/persondb";
	private String username = "root";
	private String password = "pass";

	// Model from resultSet method - every DAO has one of these
	public Person personFromResultSet(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		String firstName = resultSet.getString("firstName");
		String lastName = resultSet.getString("lastName");
		int age = resultSet.getInt("age");

		return new Person(id, firstName, lastName, age);
	}

	// CREATE
	public void create(Person person) {
		try (Connection conn = DriverManager.getConnection(connectionURL, username, password);
				Statement statement = conn.createStatement()) {
			statement.executeUpdate("INSERT INTO people(firstName, lastName, age) VALUES ('" + person.getFirstName()
					+ "', '" + person.getLastName() + "' , " + person.getAge() + ")");
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}

	}

	public void createPrepared(Person person) {
		try (Connection conn = DriverManager.getConnection(connectionURL, username, password);
				PreparedStatement statement = conn
						.prepareStatement("INSERT INTO people(firstName,lastname,age) VALUES(?,?,?)")) {

			statement.setString(1, person.getFirstName());
			statement.setString(2, person.getLastName());
			statement.setInt(3, person.getAge());
			statement.executeUpdate();
			System.out.println("Person Created");
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
		}
	}

	// READ ALL
	public Person readByID(int id) {
		try (Connection conn = DriverManager.getConnection(connectionURL, username, password);
				Statement statement = conn.createStatement()) {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM people WHERE ID=" + id);
			resultSet.next();
			return personFromResultSet(resultSet);

		} catch (SQLException e) {
//			LOGGER.error(e);
			LOGGER.error(e.getMessage());
		}
		return null;

	}

	// READ BY ID
	public List<Person> readAll() {
		try (Connection conn = DriverManager.getConnection(connectionURL, username, password);
				Statement statement = conn.createStatement()) {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM people");

			List<Person> people = new ArrayList<>();
			while (resultSet.next()) {
				people.add(personFromResultSet(resultSet));
			}

			return people;
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return null;

	}

	// UPDATE
	public void update(Person person) {
		try (Connection conn = DriverManager.getConnection(connectionURL, username, password);
				PreparedStatement statement = conn
						.prepareStatement("UPDATE people SET firstName = ? , lastName = ?, age = ? WHERE id = ?")) {

			statement.setString(1, person.getFirstName());
			statement.setString(2, person.getLastName());
			statement.setInt(3, person.getAge());
			statement.setInt(4, person.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}

	// DELETE
	public int delete(int id) {
		try (Connection conn = DriverManager.getConnection(connectionURL, username, password);
				PreparedStatement statement = conn.prepareStatement("DELETE FROM people WHERE id = ?")) {

			statement.setInt(1, id);
			return statement.executeUpdate(); // returns 0 or 1. Either deleted 1 or none

		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return 0;

	}

	@Override
	public Person modelFromResultset(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	// MVP is minimum viable product - which is minimum req

}
