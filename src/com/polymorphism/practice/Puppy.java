package com.polymorphism.practice;

import java.util.ArrayList;
import java.util.List;

public class Puppy extends Dog {

	@Override
	public void doEat(String asdasdsa) {
		System.out.println(Puppy.class + " : " + asdasdsa);
	}
	
	@Override
	public void doEat(Integer foodQuantity) {
		System.out.println(Puppy.class + " : " + foodQuantity);
	}
	
	
	public void doEat(String a, String b) {
		ArrayList<String> arr = new ArrayList<>();
		List<String> lst = new ArrayList<>();
		
	}
}
