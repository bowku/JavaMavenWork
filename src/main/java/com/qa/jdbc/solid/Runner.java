package com.qa.jdbc.solid;

public class Runner {

	public static void main(String[] args) {
		
		AreaCalculator aCalc = new AreaCalculator();
		
		Circle c = new Circle();
		
		c.setRadius(10);
		
		System.out.println(aCalc.calculateShapeArea(c));

	}

}
