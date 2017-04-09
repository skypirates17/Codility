package com.exam.practice;

/*
 * reverse the order of a number without using API functions
 */
public class ReverseNumber {

	public static void main(String[] args) {
		System.out.println(new ReverseNumber().solution1(19765));
	
		// we can also use the conversion we create in ReverseString.java
		// just convert the number to String then the result to int
		System.out.println(new ReverseString().solution1(String.valueOf(789165)));
	}
	
	public int solution1 (int num) {
		int reverse = 0;
		while (num > 0) {
			reverse *= 10;
			reverse += (num % 10);
			num /= 10;
		}
		return reverse;
	}
	
}
