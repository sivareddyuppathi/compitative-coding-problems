package com.codesignal.coding;

public class Test {

	public static void main(String[] args) {
		int n = 3, m = 9;
		int num = candies(n, m);
		System.out.println(num);
	}

	private static int candies(int n, int m) {
		if (m % n == 0) {
			return m / n;
		}

		int tempSub = m - (m % n);

		int numEach = tempSub / n;

		return numEach * n;
	}
}
