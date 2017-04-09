package com.exam.nokia;

import java.util.Arrays;

/*
 * Convert 2d array to 1d array
 */
public class ConversionArray {

	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };

		System.out.println(Arrays.toString(new ConversionArray().converTo1DimensionalArray(arr)));

	}

	public int[] converTo1DimensionalArray(int[][] arr) {
		int rowCount = arr.length;
		int columnCount = arr[0].length;

		int[] result = new int[rowCount * columnCount];

		int indexCtr = 0;
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				result[indexCtr] = arr[i][j];
				indexCtr++;
			}
		}
		return result;
	}

}
