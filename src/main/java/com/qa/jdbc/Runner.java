package com.qa.jdbc;

import java.util.List;

import com.qa.jdbc.controller.PersonController;
import com.qa.jdbc.daos.PersonDAO;
import com.qa.jdbc.domain.Person;

public class Runner {

	public static void main(String[] args) {
		TestConnection tc = new TestConnection();
		tc.testConnection();

		// CRUD functionality (CREATE, READ, UPDATE, DELETE)
		// Using DAO - Data Access Objects
		PersonDAO pDAO = new PersonDAO();
		PersonController pController = new PersonController(pDAO);

		// crud method

//		pController.create();
		pController.readAll();
//		pController.readById();
//		pController.delete();
//		pController.update();

////		
//		Person p = new Person ("Tom", "Smith",30);
//		Person q = new Person ("Mohamed","Jaleil",27);
//		
//		pDAO.create(p);

//		pDAO.createPrepared(q);

//		//read by id
//		System.out.println(pDAO.readByID(1));

		// read all
//		List<Person> people = pDAO.readAll();
//		
//		for (Person person : people) {
//			System.out.println(person);
//		}

		// Update
//		Person update = new Person(2,"Samuel", "Smith", 25);
//		pDAO.update(update);
//		
//		pDAO.delete(1);

	}

}
