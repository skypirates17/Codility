package com.codility.exam;

public class CountDiv {

	public static void main(String[] args) {
		System.out.println(new CountDiv().solution(6, 11, 2));
		System.out.println(new CountDiv().solution2(6, 11, 2));
	}

	public int solution(int A, int B, int K) {
		int count = 0;

		// A and B are integers within the range [0..2,000,000,000];
		if (!(A >= 0 && A <= 2000000000) || !(B >= 0 && B <= 2000000000)) {
			return count;
		}

		// K is an integer within the range [1..2,000,000,000];
		if (!(K >= 1 && K <= 2000000000))
			return count;

		// A ≤ B.
		if (A > B)
			return count;

		for (int i = A; i <= B; i++) {
			if (i % K == 0)
				count++;
		}
		return count;
	}

	public int solution2(int A, int B, int K) {
		int b = B / K + 1; // From 0 to B the integers divisible by K
		int a = A / K + 1; // From 0 to A the integers divisible by K

		if (A % K == 0) { // "A" is inclusive; if divisible by K then
			--a; // remove 1 from "a"
		}
		return b - a; // return integers in range
	}
}

/**
 * Write a function:
 * 
 * class Solution { public int solution(int A, int B, int K); } that, given
 * three integers A, B and K, returns the number of integers within the range
 * [A..B] that are divisible by K, i.e.:
 * 
 * { i : A ≤ i ≤ B, i mod K = 0 } For example, for A = 6, B = 11 and K = 2, your
 * function should return 3, because there are three numbers divisible by 2
 * within the range [6..11], namely 6, 8 and 10.
 * 
 * Assume that:
 * 
 * A and B are integers within the range [0..2,000,000,000]; K is an integer
 * within the range [1..2,000,000,000]; A ≤ B. Complexity:
 * 
 * expected worst-case time complexity is O(1); expected worst-case space
 * complexity is O(1).
 */
