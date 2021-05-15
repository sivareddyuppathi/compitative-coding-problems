package com.leetcode.dp;

// https://leetcode.com/problems/divisor-game/

public class DivisorGame {
	public static void main(String[] args) {
		int n = 3;
		System.out.println(divisorGame(n));
	}

	private static boolean divisorGame(int n) {
		return (n % 2 == 0);
	}
}
