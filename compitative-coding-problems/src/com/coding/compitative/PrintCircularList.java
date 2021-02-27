package com.coding.compitative;

public class PrintCircularList {


	public static void print(char a[], int n, int ind) {

	
		for (int i = ind; i < n + ind; i++) {
			int x = (i % n);
			System.out.print(a[x] + " ");
		}
			
	}

	public static void main(String argc[]) {
		char[] a = new char[] { 'A', 'B', 'C', 'D', 'E', 'F' };
		int n = 6;
		print(a, n, 3);
	}
}
