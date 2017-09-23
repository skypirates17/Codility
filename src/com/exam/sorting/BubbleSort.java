package com.exam.sorting;

/*
 * Bubble sort repetitively compares adjacent pairs of elements and swaps if necessary.
 */
public class BubbleSort {
	public static void main(String args[]) {

		int[] items = {4,3,1,5,2};
		int i, j, temp;

		for(i=0;i<items.length;i++) {

			for(j=0;j<items.length;j++) {

				if (items[j] > items[i]) {
					temp = items[i];
					items[i] = items[j];
					items[j] = temp;
				}
			}
		}

		for(int x : items) {
			System.out.println(x);
		}
	}
}
