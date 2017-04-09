package com.access.modifier.sample2;

import com.access.modifier.sample1.Student;

public class MainStudent extends Student {
	
	public MainStudent() {
		//Student stud = new Student();
		//stud.aDefaultModifier();
		//stud.aProtectedModifier();
		
		super.aProtectedModifier();
	}
	
	public static void main(String[] args) {
		new MainStudent().aProtectedModifier();
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("CALL() FINALIZE");
	}
	
}
