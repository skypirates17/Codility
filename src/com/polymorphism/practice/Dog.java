package com.polymorphism.practice;

public class Dog {

	public void doEat(String foodName) {
		System.out.println(Dog.class + " : " + foodName);
	}
	
	public void doEat(Integer foodQuantity) {
		System.out.println(Dog.class + " : " + foodQuantity);
	}
}
