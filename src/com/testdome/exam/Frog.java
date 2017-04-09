package com.testdome.exam;

public class Frog {
    public static int numberOfWays(int n) {
    	if (n == 1) {
            return 1; //step
        } else if (n == 2) {
            return 2; // (step + step) or jump
        } else {
            return numberOfWays(n - 1) + numberOfWays(n - 2); 
           // we jumped or stepped into the current field
        }
    }
    
    public static int numberOfWays2(int n) {
    	// for performance
    	int firstnumber = 0, secondnumber = 1, result = 0;  

        if (n == 1) return 1;
        if (n == 2) return 2;


        for (int i = 2; i <= n + 1; i++)  
        {  
            result = firstnumber + secondnumber;  
            firstnumber = secondnumber;  
            secondnumber = result;  
        }  

        return result;  
    }

    public static void main(String[] args) {
        System.out.println(numberOfWays(5));
        System.out.println(numberOfWays2(5));
        //step step step step
       // step step jump
        //step jump step
        //jump step step
        //jump jump
    }
}

/**
 * A frog only moves forward, but it can move in steps 1 inch long or in jumps 2
 * inches long. A frog can cover the same distance using different combinations
 * of steps and jumps.
 * 
 * Write a function that calculates the number of different combinations a frog
 * can use to cover a given distance.
 * 
 * For example, a distance of 3 inches can be covered in three ways:
 * step-step-step, step-jump, and jump-step.
 */
