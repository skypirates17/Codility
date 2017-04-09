package com.exam.nokia;

/*
 *  Factorial of n is the product of all positive descending integers
 */
public class Factorial {

	public static void main(String[] args) {
		System.out.println("5! = " + new Factorial().getFactorialByIteration(5));

		System.out.println("5! = " + new Factorial().getFactorialByRecursion(5));

	}

	public int getFactorialByIteration(int num) {
		int product = 1;
		
		for (int i = 1; i <= num; i++) {
			product *= i;
		}
		
		return product;
	}
	
	public int getFactorialByRecursion(int num) {
		if (num == 1) {
			return 1;
		}
		else {
			return (num * getFactorialByRecursion(num - 1));
		}
	}
}
