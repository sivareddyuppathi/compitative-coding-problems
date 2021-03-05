package com.coding.compitative;

public class MinRotationsToGetSameString {

	private static int findRotations(String str) {

		String tmp = str + str;
		int n = str.length();

		for (int i = 1; i <= n; i++) {

			String substring = tmp.substring(i, i + str.length());

			if (str.equals(substring))
				return i;
		}
		return n;
	}

	public static void main(String[] args) {
		String str = "siva";
		System.out.println(findRotations(str));
	}
}
