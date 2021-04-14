package com.codechef.coding.mar2021.div3;

public class ChefAndGroups {

	public static void main(String[] args) {
		String str = "101111010";

		int noOfGroups = findNumOfGroups(str);
		System.out.println(noOfGroups);
	}

	private static int findNumOfGroups(String str) {

		int onOfGropus = 0;
		int start = 0;

		int size = str.length() - 1;

		for (int i = 0; i < size; i++) {
			if (str.charAt(i) == '1') {
				start++;
			}
			if (start >= 1 && str.charAt(i + 1) == '0') {
				onOfGropus++;
				start = 0;
			}
		}
		if (str.charAt(size) == '1') {
			onOfGropus++;
		}
		return onOfGropus;
	}

}
