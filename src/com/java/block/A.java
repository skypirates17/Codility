package com.java.block;

public class A {

	public A() {
		System.out.println("Class A: Constructor");
	}
	static {
		System.out.println("Class A: Static block 1");
	}
	
	{
		System.out.println("Class A: Empty block 1");
	}
	
	
	static {
		System.out.println("Class A: Static block 2");
	}
}
