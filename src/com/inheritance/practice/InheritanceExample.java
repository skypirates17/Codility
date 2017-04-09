package com.inheritance.practice;

public class InheritanceExample {
	public static void main(String[] args) {
		Dog d = new Dog();
		
		// methods inherit from Animal (Parent class)
		d.eat();
		d.sleep();
		
		// method from Dog (Current / Child Class)
		d.bark();
	}
}
