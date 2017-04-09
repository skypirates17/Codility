package com.java.sysout.main;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Review {
	public static void main(String[] args) {
		// Converting Integer to int
		Integer a = new Integer(3);

		// converting Integer to int
		int i = a.intValue();

		// unboxing, now compiler will write a.intValue() internally
		int j = a;
		
		List<? super Number> l = new ArrayList<>();
		l.add(new Integer(213123));
		
	}

	public void implicitCasting() {
		int i = 100;
		long l = i; // no explicit type casting required
		float f = l; // no explicit type casting required
	}

	public void explicitCasting() {
		double d = 100.04;
		long l =  (long) d; // explicit type casting required
		int i = (int) l; // explicit type casting required
	}
}

/*
 * final class System { public final static PrintStream out = null; }
 * 
 * class PrintStream { public void println() {
 * 
 * } }
 */