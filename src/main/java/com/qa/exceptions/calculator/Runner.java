package com.qa.exceptions.calculator;

public class Runner {

	public static void main(String[] args) {
		
		Division d = new Division();
		
		try {
			d.interaction();
		} catch (DivisionExceptions e) {
			System.out.println("you can't divide by 0");
//			e.printStackTrace();
		}
		
	}

}
