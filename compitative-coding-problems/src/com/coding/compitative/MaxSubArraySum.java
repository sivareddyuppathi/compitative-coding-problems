package com.coding.compitative;

import java.util.Scanner;

public class MaxSubArraySum {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();

		int[] arr = new int[size];

		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(maxSubArraySum(arr));
		sc.close();
	}

	private static int maxSubArraySum(int[] nums) {
		int result = nums[0];
		int sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum = Math.max(nums[i], sum + nums[i]);
			result = Math.max(result, sum);
		}
		return result;
	}
}
