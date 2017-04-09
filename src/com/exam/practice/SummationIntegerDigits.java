package com.exam.practice;

/*
 * get the sum of each digits in an Integer without using any String build in functions or Array
 */
public class SummationIntegerDigits {

	public static void main (String [] args) {
		System.out.println(new SummationIntegerDigits().solution(769));
	}
	public int solution(int N) {
        int sum = 0;
        while (N > 0) {
            sum += N % 10;
            N = N / 10;
        }
        return sum;
	}
}
