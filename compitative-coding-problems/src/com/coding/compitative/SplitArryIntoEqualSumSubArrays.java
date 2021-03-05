package com.coding.compitative;

public class SplitArryIntoEqualSumSubArrays {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 5 };

		findSplitPoint(arr, arr.length);
	}

	private static int findSplitPoint(int[] arr, int n) {

		int leftSum = 0;

		for (int i = 0; i < n; i++)
			leftSum += arr[i];

		int rightSum = 0;

		for (int i = n - 1; i >= 0; i--) {
			rightSum += arr[i];
			leftSum -= arr[i];
			if (rightSum == leftSum)
				return i;
		}
		return -1;
	}

}
