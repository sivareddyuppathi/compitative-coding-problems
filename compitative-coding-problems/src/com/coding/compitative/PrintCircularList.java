package com.coding.compitative;

public class PrintCircularList {

	public static void print(char a[], int arrSize, int index) {

		for (int i = index; i < arrSize + index; i++) {
			int x = (i % arrSize);
			System.out.print(a[x] + " ");
		}

	}

	public static void main(String argc[]) {
		char[] a = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I' };
		int arrSize = a.length;
		print(a, arrSize, 5);
	}
}
