package com.exam.sorting;

import java.util.Arrays;

public class SortingAlgorithm {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new SortingAlgorithm().doBubbleSort(new int[] { 4, 3, 1, 5, 2 })));
		System.out.println(Arrays.toString(new SortingAlgorithm().doSelectionSort(new int[] { 4, 3, 1, 5, 2 })));
		System.out.println(Arrays.toString(new SortingAlgorithm().doInsertionSort(new int[] { 4, 3, 1, 5, 2 })));
	}

	public int[] doBubbleSort(int a[]) {
		// Bubble sort repetitively compares adjacent pairs of elements and swaps if necessary.
		int i, j, temp;

		for (i = 0; i < a.length; i++) {
			for (j = 0; j < a.length; j++) {
				if (a[j] > a[i]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}

	public int[] doSelectionSort(int a[]) {
		// Selection sort is to repetitively pick up the smallest element and put it into the right position.

		return a;
	}

	public int[] doInsertionSort(int a[]) {
		// Insertion sort maintains a sorted sub-array, and repetitively inserts new elements into it.
		int i, j, temp;

		for (i = 1; i < a.length; i++) {
			temp = a[i]; 

			for (j = i; j > 0; j--) { 
				if (a[j - 1] < temp)
					break;
				a[j] = a[j - 1];
			}

			a[j] = temp;
		}
		return a;
	}

}
