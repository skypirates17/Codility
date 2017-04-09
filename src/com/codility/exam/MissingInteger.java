package com.codility.exam;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class MissingInteger {
	public static void main (String [] args) {
		// 1,2,3,5,1,3,5,1
		// 1
		// -1
		int[] sample = new int[] {1,2,3};
		
		System.out.println(new MissingInteger().solution(sample));
	}

	public int solution(int[] A) {
		Arrays.sort(A);
		Set<Integer> ts = new TreeSet<Integer>(Arrays.asList(cInteger(A)));
		
		Integer result = 0;
		Integer prevElement = result;
		
		for (Iterator<Integer> it = ts.iterator(); it.hasNext(); ) {
			Integer f = it.next();
			if (result == 0) {
				prevElement = result = f; continue;
			}
			prevElement = result;
			result++; 
			if (result.compareTo(f) != 0) {
				prevElement++;
				return prevElement < 0 ? 1 : prevElement;
			}
	    }
		
		prevElement++;
		return prevElement < 0 ? 1 : prevElement;
	}

	public Integer[] cInteger(int[] oldArray) {
		Integer[] newArray = new Integer[oldArray.length];
		int i = 0;
		for (int value : oldArray) {
			newArray[i++] = Integer.valueOf(value);
		}

		return newArray;
	}
}
