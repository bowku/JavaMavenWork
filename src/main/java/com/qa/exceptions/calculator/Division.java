package com.qa.exceptions.calculator;

import java.util.Scanner;

//you can put try catch in this division class
public class Division {

	public float Divide(float a, float b) throws DivisionExceptions {
		
		if (b == 0) {
			throw new DivisionExceptions("You can't divide by 0");
		} 
		return a/b;
		
		
		
		
	}
	
	public void interaction() throws DivisionExceptions {
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;

		while (flag) {

			System.out.println("Enter first number : ");
			Integer a = scanner.nextInt();

			scanner.nextLine();

			System.out.println("Enter second number : ");
			Integer b = scanner.nextInt();

			scanner.nextLine();

			System.out.println(Divide(a,b));
			

			System.out.println("Continue ? (y/n)");


			String choice = scanner.nextLine();

			if (choice.equalsIgnoreCase("y")) {
				continue;
			} else if (choice.equalsIgnoreCase("n")) {
				System.out.println("Closing calculator");
				flag = false;
				continue;
			} else {
				System.out.println("invalid input. restarting app.");
			}

		}
		
		scanner.close();
	}

	
	
}
