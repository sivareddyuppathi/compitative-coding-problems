package com.coding.compitative;

import java.util.Arrays;

public class MinNoOfCoinsRequired {

	private static int minNumOfCoins(int[] coins, int amount) {
		if (coins.length == 0 || amount == 0)
			return 0;

		int[] store = new int[amount + 1];
		Arrays.fill(store, amount + 1);

		store[0] = 0;

		for (int i = 0; i <= amount; i++) {
			for (int coin : coins) {
				if (coin <= i) {
					store[i] = Math.min(store[i], 1 + store[i - coin]);
				}
			}
		}
		return store[amount] > 0 ? store[amount] : -1;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 10, 20, 50, 100 };
		System.out.println(minNumOfCoins(arr, 99));

		// This is the solution for only those type of cents(1,10,20,50,100)
		System.out.println(minNoOfCoins(99));
	}

	private static int minNoOfCoins(int amount) {

		int minCoins = 0;

		while (amount > 0) {

			if (amount >= 100) {
				amount -= 100;
			} else if (amount >= 50) {
				amount -= 50;
			} else if (amount >= 20) {
				amount -= 20;
			} else if (amount >= 10) {
				amount -= 10;
			} else {
				amount -= 1;
			}
			minCoins++;
		}

		return minCoins;

	}

}
