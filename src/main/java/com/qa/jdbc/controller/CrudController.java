package com.qa.jdbc.controller;

import java.util.List;

public interface CrudController<T> {

	void create();

	void readById();

	void readAll();

	void update();

	void delete();
}
