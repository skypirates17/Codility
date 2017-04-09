package com.exam.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * 
 */
public class Badminton {
	
	private int playerCount;
	private List<List<String>> result;
	private List<List<String>> resultTemp;
	private List<List<String>> finalDraft;
	
	public static void main (String [] args) {
		Badminton badminton  = new Badminton(11);
		badminton.print2By2Draft();
	}
	
	public Badminton(int playerCount) {
		this.playerCount = playerCount;
		this.set2By2Draft();
		this.resultTemp = this.result;
	}
	
	private void set2By2Draft() {
		result = new ArrayList<>();
		
		List<String> partner = null;
		for (int i = 1; i <= this.playerCount; i++) {
			for (int j = i+1; j <= this.playerCount; j++) {
				partner = new ArrayList<>();
				partner.add(String.valueOf(i));
				partner.add(String.valueOf(j));
				result.add(partner);
			}
		}
	}
	
	public void print2By2Draft () {
		this.setFinalDraft();
		for (Iterator<List<String>> it = finalDraft.iterator(); it.hasNext();) {
			List<String> sample = it.next();
			for (Iterator<String> its = sample.iterator(); its.hasNext();) {
				System.out.print(its.next() + " ");
			}
			
			System.out.print(" vs ");
			sample = it.next();
			for (Iterator<String> its = sample.iterator(); its.hasNext();) {
				System.out.print(its.next() + " ");
			}
			
			System.out.println("");
			
		}
	}
	
	private void setFinalDraft() {
		finalDraft = new ArrayList<>();
		for (Iterator<List<String>> it = resultTemp.iterator(); it.hasNext();) {
			List<String> sample = it.next();
			
			finalDraft.add(sample);
			finalDraft.add(getOpponent(sample));
			
			it.remove();
		}
	}
	
	private List<String> getOpponent(List<String> opponent) {
		List<String> partner = null;
		boolean hasSamePlayer = false;
		for (Iterator<List<String>> it = resultTemp.iterator(); it.hasNext();) {
			partner = it.next();
			hasSamePlayer = false;
			for (Iterator<String> its = partner.iterator(); its.hasNext();) {
				String num = its.next();
				for (Iterator<String> its2 = opponent.iterator(); its2.hasNext();) {
					//System.out.println(its.next().equals(its2.next()));
					if (num.equals(its2.next())) {
						hasSamePlayer = true;break;
					}
				}
				if (hasSamePlayer) break;
			}
			if (!hasSamePlayer) {
				//it.remove();
				return partner;
			}
		}
		return partner;
	}
}
