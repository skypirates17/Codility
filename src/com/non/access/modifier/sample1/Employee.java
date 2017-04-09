package com.non.access.modifier.sample1;

public class Employee {

	public String name;
	public static String id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static String getId() {
		return id;
	}
	public static void setId(String id) {
		Employee.id = id;
	}

}
