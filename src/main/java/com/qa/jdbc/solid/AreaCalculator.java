package com.qa.jdbc.solid;

public class AreaCalculator {

	public double calculateShapeArea(Shape shape) {
		return shape.calculateArea();
	}

	// this class violated open/close because i can add another method. you cant
	// modify it, you can extend though.

}
