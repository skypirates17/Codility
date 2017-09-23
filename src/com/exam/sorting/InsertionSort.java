package com.exam.sorting;

/*
 * Insertion sort maintains a sorted sub-array, and repetitively inserts new elements into it.
 */
public class InsertionSort {
	public static void main(String args[]) {

		int[] items = { 4, 3, 1, 5, 2 };
		int i, j, temp;

		for (i = 1; i < items.length; i++) {
			temp = items[i]; 

			for (j = i; j > 0; j--) { 
				if (items[j - 1] < temp)
					break;
				items[j] = items[j - 1];
			}

			items[j] = temp;
		}

		for (int x : items) {
			System.out.println(x);
		}
	}
}