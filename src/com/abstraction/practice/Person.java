package com.abstraction.practice;

import java.util.List;
import java.util.Map;

public class Person {
	
	public Person (List<Map<List,String>> sample) {
		
	}
	
	public Person (Map<Map<String, Object>, String> sample2) {
		
	}
	
	/*
	public Person (int num) {
		
	}
	
	public Person (String str) {
		
	}
	*/
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
