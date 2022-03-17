package com.qa.jdbc.openclose;

public class CasualGreeting implements Greeting{

	public String greet() {
		return "Sup m8?";
	}

	@Override
	public String toString() {
		return "CasualGreeting [greet()=" + greet() + "]";
	}

}
