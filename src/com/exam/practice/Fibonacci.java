package com.exam.practice;

/*
 * The Fibonacci sequence is a set of numbers that starts with a one or a zero, 
 * followed by a one, and proceeds based on the rule that each number is equal to the 
 * sum of the preceding two numbers.
 */
public class Fibonacci {

	public static void main(String[] args) {
		for (int i = 1; i <= 12; i++)
			System.out.print(new Fibonacci().printFibonacciByRecursion(i) + " ");
		
		System.out.println("");
		new Fibonacci().printFibonacciByIteration(12);
	}
	
	public void printFibonacciByIteration(int num) {
		int a = 1;
        int b = 1;
        int temp = 0;
        
        for (int i = 0; i < num; i++) {
            System.out.print(a + " ");
            temp = a;
            a = b;
            b = temp + b;
        }
	}
	
	public int printFibonacciByRecursion(int num) {
		 if(num <= 1) {
			 return num;
		 } else {
			 return printFibonacciByRecursion(num - 1) + printFibonacciByRecursion(num - 2);
		 }
		      
	}
}
