package com.leetcode.dp;

public class BestTimeToSellAndBuyStock {

	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };

		System.out.println(maxProfitBruteForce(prices)); // O(n^2)
		System.out.println(maxProfit(prices)); // O(n) => Ittrative
		System.out.println(maxProfitRecur(prices)); // O(n)
	}

	private static int maxProfitRecur(int[] prices) {
		if (prices.length == 0)
			return 0;

		return maxProfitRecurUtil(prices, 0, Integer.MAX_VALUE, 0);
	}

	private static int maxProfitRecurUtil(int[] prices, int index, int minPrice, int maxProfit) {
		if (prices.length == index)
			return maxProfit;

		minPrice = Math.min(maxProfit, prices[index]);
		maxProfit = Math.max(maxProfit, prices[index] - minPrice);
		return maxProfitRecurUtil(prices, ++index, minPrice, maxProfit);
	}

	private static int maxProfit(int[] prices) {

		int minPriceDayToByStock = Integer.MAX_VALUE;
		int maxProfitDayToSellStock = 0;

		for (int i = 0; i < prices.length; i++) {

			minPriceDayToByStock = Math.min(minPriceDayToByStock, prices[i]);

			maxProfitDayToSellStock = Math.max(maxProfitDayToSellStock, prices[i] - minPriceDayToByStock);
		}
		return 0;
	}

	private static int maxProfitBruteForce(int[] prices) {
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				int currProfit = prices[j] - prices[i];
				maxProfit = Math.max(maxProfit, currProfit);
			}
		}
		return maxProfit;
	}
}
