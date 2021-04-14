package com.codeforce.coding.chalanges;

import java.util.Scanner;

public class NextRound158A {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		int[] scores = new int[n];
		for (int i = 0; i < n; i++) {
			scores[i] = s.nextInt();
		}
		System.out.println(getNumberOfNextRounds(n, k, scores));
	}

	public static int getNumberOfNextRounds(int n, int k, int[] scores)  {	
		int count = 0; 
		for (int i = 0; i < n; i++) { 
			if (scores[i] >= scores[k-1] && scores[i] > 0) {
				count++;
			}
		}
		return count;
	}
}