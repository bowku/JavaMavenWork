package com.qa.exceptions;

public class Maths {

	public void multiply(int a, int b) throws MultiplyByFiveException {
		int result;

		if (a == 5 || b == 5) {
			throw new MultiplyByFiveException("You can't multiply by 5");
		}

		result = a * b;

		System.out.println(result);
	}

}
