package com.exam.sorting;

/*
 * Selection sort is to repetitively pick up the smallest element and put it into the right position.
 */
public class SelectionSort {
	public static void main(String args[]) {

		int[] items = {4,3,1,5,2};
		int i, j, temp;

		for(i=0;i<items.length;i++) {

			for(j=i+1;j<items.length;j++) {

				if (items[j] < items[i]) {
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