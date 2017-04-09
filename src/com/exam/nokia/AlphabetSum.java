package com.exam.nokia;

import java.util.Arrays;
import java.util.List;

public class AlphabetSum {

	public static void main(String[] args) {
		System.out.println(new AlphabetSum().getResult1("%^&*AbcD "));
		
		System.out.println(new AlphabetSum().getResult2("%^&*AbcD "));
	}
	
	public int getResult1 (String word) {
       int result = 0;
       String [] arrLetter = "abcdefghijklmnopqrstuvwxyz".split("");

       // OPTIONAL - replace all characters that are not alpha (lower case)
       word = word.toLowerCase().replaceAll("[^a-z]" ,"");
       
       String[] arrWord = word.split("");
       
       for (int i = 0; i < arrWord.length; i++) {
              for (int j = 0; j < arrLetter.length; j++) {
                     if (arrWord[i].equals(arrLetter[j])) {
                            result += (j+1); break;
                     }
              }
       }
       
       return result;
	}
	
	public int getResult2(String word) {
		int result = 0;
		List<String> alphabetList = Arrays.asList("abcdefghijklmnopqrstuvwxyz".split(""));
		
		// OPTIONAL - replace all characters that are not alpha (lower case)
		word = word.toLowerCase().replaceAll("[^a-z]" ,"");
		
		List<String> wordList = Arrays.asList(word.split(""));
		
		for (String str: wordList) {
			result += (alphabetList.indexOf(str) + 1);
		}
		
		return result; 
	}

}
