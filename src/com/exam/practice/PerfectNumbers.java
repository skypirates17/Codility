package com.exam.practice;

/*
 * Perfect number, a positive integer that is equal to the sum of its proper divisors. 
 * The smallest perfect number is 6, which is the sum of 1, 2, and 3. 
 * Other perfect numbers are 28, 496, and 8,128.
 */
public class PerfectNumbers {

	public static void main(String[] args) {
		System.out.println(new PerfectNumbers().isPerfectNumber(8128));
	
		new PerfectNumbers().printPerfectNumbers(1000000);
	}
	
	public boolean isPerfectNumber (int num) {
		int sumDivisor = 0;
		
		for (int i = 1; i < num; i++) {
			if (num%i == 0) {
				sumDivisor += i;
			}
		}
		
		return sumDivisor == num;
	}
	
	public void printPerfectNumbers (int range) {
		int sumDivisor = 0;
		for (int i = 1; i < range; i++) {
			for (int j = 1; j < i; j++) {
				if (i%j == 0) {
					sumDivisor += j;
				}
			}
			
			if (sumDivisor == i) {
				System.out.print(i + " ");
			}
			sumDivisor = 0;
		}
	}
}
