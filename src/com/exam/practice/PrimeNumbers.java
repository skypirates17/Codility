package com.exam.practice;

/*
 * a number is a prime if it is only divisible by itself and 1
 */
public class PrimeNumbers {

	public static void main(String[] args) {
		System.out.println(new PrimeNumbers().isPrime(999));
		
		new PrimeNumbers().printPrimeNumbers(150);
	}
	
	public boolean isPrime (int num) {
		boolean result = true;
		
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				result=false;break;
			}
		}
		
		return result;
	}
	
	public void printPrimeNumbers (int range) {
		boolean isPrime = true;
		
		for (int i = 1; i <= range; i++) {
			for (int j = 2; j < i; j++) {
				if ( i % j == 0) {
					isPrime = false; break;
				}
			}
			
			if (isPrime) {
				System.out.print(i + " ");
			}
			isPrime = true;
		}
	}
	
	
}
