package com.coding.compitative;

import java.util.Arrays;

public class SplitArryIntoEqualSumSubArrays {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 5 };

		int splitPoint = findSplitPoint(arr, arr.length);

		int[] rightPart = Arrays.copyOfRange(arr, 0, splitPoint);
		int[] leftPart = Arrays.copyOfRange(arr, splitPoint + 1, arr.length - 1);

//		#1
		Arrays.stream(rightPart).forEach(System.out::print);
//		#2
		Arrays.asList(leftPart).stream().forEach(s -> System.out.println(s));
//		#3
		System.out.println(Arrays.toString(rightPart));
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
