package com.exam.practice;

public class SwapNumber {

	public static void main (String [] args) {
		// 3 ways to swap numbers without using third / temp variable
		
		// addition and subtraction
		new SwapNumber().doSwap1();
		
		// multiplication and division
		new SwapNumber().doSwap2();
		
		// bitwise operator
		new SwapNumber().doSwap3();
	}
	
	public void doSwap1 () {
		
		int firstNum = 10;
		int secondNum = 7;
		
		firstNum = firstNum + secondNum;
		secondNum = firstNum - secondNum;
		firstNum = firstNum - secondNum;
		
		System.out.println("firstNum : " + firstNum);
		System.out.println("secondNum : " + secondNum);
	}
	
	public void doSwap2 () {
		
		int firstNum = 10;
		int secondNum = 7;
		
		firstNum = firstNum * secondNum;
		secondNum = firstNum / secondNum;
		firstNum = firstNum / secondNum;
		
		System.out.println("firstNum : " + firstNum);
		System.out.println("secondNum : " + secondNum);
	}
	
	public void doSwap3 () {
		
		int firstNum = 10;
		int secondNum = 7;
		
		firstNum = firstNum ^ secondNum;
		secondNum = firstNum ^ secondNum;
		firstNum = firstNum ^ secondNum;
		
		System.out.println("firstNum : " + firstNum);
		System.out.println("secondNum : " + secondNum);
	}
}
