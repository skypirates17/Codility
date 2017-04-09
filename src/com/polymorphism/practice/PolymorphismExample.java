package com.polymorphism.practice;

public class PolymorphismExample {

	public static void main(String[] args) {
		Dog dog = new Puppy();
		dog.doEat(10);
		dog.doEat("CHICKEN");
		//Puppy pup = new Dog();
		
		Dog dog1 = new Dog();
		dog1.doEat(11);
		dog1.doEat("Bone");

		Puppy pup = new Puppy();
		pup.doEat(12);
		pup.doEat("Milk");
	}

}
