package com.exam.practice;

/*
 * Armstrong Number in Java: Armstrong number is a number that is equal to the
 * sum of cubes of its digits
 */
public class ArmstrongNumber {

	public static void main(String[] args) {
		System.out.println(new ArmstrongNumber().isArmstrong(1531));
		
		new ArmstrongNumber().printArmstrongNumbers(1000);
	}
	
	public boolean isArmstrong(int num) {
		int summationCubes = 0;
		int a = 0;
		int temp = num;
		
		while (temp > 0) {
			a = temp % 10;
			temp /= 10;
			summationCubes += (a*a*a);
		}
		
		return (num==summationCubes);
	}
	
	public void printArmstrongNumbers (int range) {
		
		for (int i = 1; i <= range; i++) {
			int temp = i;
			int a = 0;
			int summationCubes = 0;
					
			while (temp > 0) {
				a = temp % 10;
				temp /= 10;
				summationCubes += (a*a*a);
			} 
			
			if (i == summationCubes) System.out.println(i);
		}
	}
}
