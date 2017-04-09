package com.exam.practice;

/*
 * reverse a string without using any API function
 */
public class ReverseString {

	public static void main(String[] args) {
		System.out.println(new ReverseString().solution1("johnrey"));
		System.out.println(new ReverseString().solution2("urbano"));
	}

	public String solution2(String original) {
		// using string buffer / string builder
		return new StringBuffer(original).reverse().toString();
	}

	public String solution1(String original) {
		// using charAt
		String reverse = "";
		for (int i = (original.length() - 1); i >= 0; i--) {
			reverse += original.charAt(i);
		}
		return reverse;
	}
}
