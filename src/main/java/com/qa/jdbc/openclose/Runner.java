package com.qa.jdbc.openclose;

public class Runner {

	public static void main(String[] args) {

		FormalGreeting fg = new FormalGreeting();
		CasualGreeting cg = new CasualGreeting();
		Greeter gr = new Greeter(cg);

		System.out.println(gr.greet());

//		System.out.println(fg);
//		System.out.println(cg);

	}

}
