package com.java.block;

/**
 * <b>url</b> https://www.google.com.ph/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=static+and+instance+blocks+in+java
 * @author Hp
 * 
 */
public class B extends A {//extends A {

	public B () {
		System.out.println("Class B: Constructor");
	}
	
	public static void main(String[] args) {
		System.err.println("==================");
		
//		System.out.println(new A());
		System.err.println("==================");
		
		System.out.println(new B());
		System.err.println("==================");
		
		A a= new A();
		System.out.println(a);
		System.err.println("==================");
		
		B b = new B();
		System.out.println(b);
		System.err.println("==================");
		
		A a2= new A();
		System.out.println(a2);
		System.err.println("==================");
		
		
		/*
		A a = new B();
		System.out.println(a);
		System.err.println("==================");
		*/
	}

	static {
		System.out.println("Class B: Static block 1");
	}
	
	{
		System.out.println("Class B: Empty block 1");
	}
	
	
	static {
		System.out.println("Class B: Static block 2");
	}

}
