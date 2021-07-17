package com.coding.binarysearch;

public class MinInRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };

		System.out.println(findMinIttr(nums));
		System.out.println(findMinRecu(nums));
		System.out.println(findMinLinear(nums));
	}

//	TC: O(n) SC:O(1)
	private static int findMinLinear(int[] nums) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < min) {
				min = nums[i];
			}
		}
		return min;
	}

//	TC: O(logn) SC:O(1)
	public static int findMinIttr(int[] nums) {
		int l = 0, r = nums.length - 1;

		while (l < r) {
			int mid = l + (r - l) / 2;

			if (nums[mid] > nums[r])
				l = mid + 1;
			else
				r = mid;
		}
		return nums[l];
	}

//	TC: O(logn) SC:O(n)
	public static int findMinRecu(int[] nums) {
		return findMin(nums, 0, nums.length - 1);
	}

	public static int findMin(int[] nums, int low, int high) {
		if (low == high)
			return nums[low];
		int mid = (low + high) / 2;
		if (nums[mid] > nums[high]) {
			return findMin(nums, mid + 1, high);
		} else
			return findMin(nums, low, mid);
	}
}
