package com.qa.jdbc.openclose;

public class FormalGreeting implements Greeting{
	
	public String greet() {
		return "Good evening, Sir.";
	}

	@Override
	public String toString() {
		return "FormalGreeting [greet()=" + greet() + "]";
	}
	
	

}
