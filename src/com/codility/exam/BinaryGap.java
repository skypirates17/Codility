package com.codility.exam;

/*
 * 
 * 100% working according to codility
 * 
 */
public class BinaryGap {

	public static void main(String[] args) {
		// 529 64 1041 195 38993
		System.out.println(new BinaryGap().solution(38993));
	}

	public int solution(int N) {
		int result = 0;
		String bin = Integer.toBinaryString(N);

		// split string including the delimiters
		String[] arrBin = bin.split("((?<=1)|(?=1))");

		// checking of longest gap of zeros
		// start from 1 since split return empty string in index zero
		for (int i = 0; i < arrBin.length; i++) {

			if (arrBin[i].equals("1") || arrBin[i].isEmpty()) {
				continue;
			}

			if (arrBin[i].length() > result) {
				if (i > 0 && i != arrBin.length - 1) {
					if (arrBin[i - 1].equals("1") && arrBin[i + 1].equals("1")) {
						result = arrBin[i].length();
					}
				}
			}
		}

		return result;

	}
}

/**
 * A binary gap within a positive integer N is any maximal sequence of
 * consecutive zeros that is surrounded by ones at both ends in the binary
 * representation of N.
 * 
 * For example, number 9 has binary representation 1001 and contains a binary
 * gap of length 2. The number 529 has binary representation 1000010001 and
 * contains two binary gaps: one of length 4 and one of length 3. The number 20
 * has binary representation 10100 and contains one binary gap of length 1. The
 * number 15 has binary representation 1111 and has no binary gaps.
 * 
 * Write a function:
 * 
 * int solution(int N);
 * 
 * 
 * that, given a positive integer N, returns the length of its longest binary
 * gap. The function should return 0 if N doesn't contain a binary gap.
 * 
 * For example, given N = 1041 the function should return 5, because N has
 * binary representation 10000010001 and so its longest binary gap is of length
 * 5.
 * 
 * Assume that:
 * 
 * •N is an integer within the range [1..2,147,483,647].
 * 
 * Complexity:
 * 
 * •expected worst-case time complexity is O(log(N)); •expected worst-case space
 * complexity is O(1).
 */


/**
 * SIMPLER CODE
 * 
 * int curr = 0; int max = 0;
 * 
 * while (N > 0) { int bit = N & 1; N >>= 1; if (bit == 1) { if (curr > max) {
 * max = curr; } curr = 0; } else { curr++; } }
 * 
 * return max;
 */
