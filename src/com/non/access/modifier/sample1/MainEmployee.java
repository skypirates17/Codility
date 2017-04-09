package com.non.access.modifier.sample1;

public class MainEmployee {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setId("035-2009-0483");
		
		System.out.println(Employee.getId());
		
		Employee emp2 = new Employee();
		System.out.println(emp2.getId());
		
		emp2.setId("1402-909081-1231");
		
		System.out.println(Employee.getId());
		System.out.println(emp.getId());
	}
	
	
	static int count;
	
	static void foo() {
		
	}
	
	static {
		
	}
	
	static class InnterStatic {
		
	}

}
