package com.qa.exceptions;

public class Runner {

	public static void main(String[] args) {
		Maths maths = new Maths();

		try {
			maths.multiply(5, 20);
		} catch (MultiplyByFiveException mbfe) {
			System.out.println("Can't multiply by 5");
//			mbfe.printStackTrace();
		}
	}
}
