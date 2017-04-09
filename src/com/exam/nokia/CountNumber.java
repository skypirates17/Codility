package com.exam.nokia;

import java.util.Arrays;
import java.util.List;

public class CountNumber {
 
	public static void main(String[] args) {
		new CountNumber().countNum("1 2 2 1 3 3 5 5");
	}
	
	public void countNum(String str) {
		List<String> numList = Arrays.asList(str.split(" "));
		
		for (String numStr : numList) {
			System.out.println(numStr);
		}
	}
}
