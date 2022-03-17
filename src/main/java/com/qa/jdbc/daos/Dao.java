package com.qa.jdbc.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


//generic is written <>
public interface Dao <T> {
	
	public void create(T t);
	
	T readByID(int id);
	
	List<T> readAll();
	
	void update(T t);
	
	int delete(int id);
	
	T modelFromResultset(ResultSet resultSet) throws SQLException;
	

}
