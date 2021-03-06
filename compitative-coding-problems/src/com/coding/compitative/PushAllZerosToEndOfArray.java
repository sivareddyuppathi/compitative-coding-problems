package com.coding.compitative;

public class PushAllZerosToEndOfArray {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 0, 2, 0, 8, 0, 6, 2 };
		pushZerosToEnd(arr);

		for (int val : arr) {
			System.out.print(val + " ");
		}
	}

	private static void pushZerosToEnd(int[] arr) {
		int index = 0;

		for (int value : arr) {
			if (value != 0) {
				arr[index++] = value;
			}
		}

		while (index < arr.length) {
			arr[index++] = 0;
		}

	}
}
