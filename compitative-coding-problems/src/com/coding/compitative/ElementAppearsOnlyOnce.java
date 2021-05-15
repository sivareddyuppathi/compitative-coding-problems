package com.coding.compitative;

public class ElementAppearsOnlyOnce {

	public static void main(String[] args) {
		int arr[] = { 3, 3, 2, 3 };
		int unique = findElementOccursOnlyOnce(arr);
		System.out.println(unique);
	}

	private static int findElementOccursOnlyOnce(int[] nums) {
		int result = nums[0]; // Start with the first element
		for (int i = 1; i < nums.length; i++) {
			result ^= nums[i];
		}
		return result;
	}

}
