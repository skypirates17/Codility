package com.codility.exam;

import java.util.Arrays;

/*
 * 100% working
 */
public class PermCheck {

	public static void main(String[] args) {
		System.out.println(new PermCheck().solution(new int[] {1,2,3,4,5}));
	}

	public int solution(int[] A) {
		int result = 1;
		Arrays.sort(A);
		
		for (int i = 0; i < A.length; i++) {
			if (A[i] == i+1) {
				continue;
			} else {
				result = 0;
				break;
			}
		}
		
		return result;
	}
}
