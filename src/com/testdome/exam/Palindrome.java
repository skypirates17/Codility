package com.testdome.exam;

public class Palindrome {
	  public static boolean isPalindrome(String str) {
		  boolean result = false;
		  str = str.replaceAll("[^a-zA-Z]", "");
		  String reverse =  new StringBuilder(str).reverse().toString();
		  
		  if (str.equalsIgnoreCase(reverse)) result = true;
		  
		  return result;
	    }

	    public static void main(String[] args) {
	        System.out.println(isPalindrome("Noel sees Leon."));
	    }
}
