package com.qa.jdbc.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.qa.jdbc.daos.PersonDAO;
import com.qa.jdbc.domain.Person;

public class PersonController implements CrudController <Person> {

	private Scanner scanner = new Scanner(System.in);
	private PersonDAO personDAO;

	public PersonController(PersonDAO personDAO) {
		this.personDAO = personDAO;

	}

	public void create() {
		System.out.println("please enter first name");
		String firstName = scanner.nextLine();

		System.out.println("please enter last name");
		String lastName = scanner.nextLine();

		System.out.println("please enter age");
		int age = scanner.nextInt();

		Person input = new Person(firstName, lastName, age);
		personDAO.createPrepared(input);

		System.out.println("Customer created");
	};

	public void readAll() {
		List<Person> people = personDAO.readAll();

		for (Person person : people) {
			System.out.println(person);
		}
	}

	public void readById() {
		System.out.println("Enter id number: ");
		int id = scanner.nextInt();
		System.out.println(personDAO.readByID(id));
	};

	public void update() {
		System.out.println("please enter first name");
		String firstName = scanner.nextLine();

		System.out.println("please enter last name");
		String lastName = scanner.nextLine();

		System.out.println("please enter age");
		int age = scanner.nextInt();

		System.out.println("please enter id");
		int id = scanner.nextInt();

		personDAO.update(new Person(id, firstName, lastName, age));
		System.out.println("person updated");

	};

	public void delete() {
		System.out.println("please enter id");
		int id = scanner.nextInt();

		if (personDAO.delete(id) != 0) {
			System.out.println("Person with id" + id + " is deleted");
		} else {
			System.out.println("Person not found"); // this could be an exception
		}

	}


}
