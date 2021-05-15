package com.leetcode.dp;

public class LongestCommonSubSequence {

	public static void main(String[] args) {
		String str1 = "abcde";
		String str2 = "ace";
		int res = longestCommonSubsequence(str1, str2);
		System.out.println(res);
	}

	private static int longestCommonSubsequence(String str1, String str2) {
		int l1 = str1.length();
		int l2 = str2.length();

		// Dynamic Programming Bottom Up Approach

		// cache[l1][l2] => LCS till length l1 and l2 (from starting) of strings
		int[][] cache = new int[l1 + 1][l2 + 1];

		for (int i = 1; i <= l1; i++) {
			for (int j = 1; j <= l2; j++) {
				// Current characters are equal in both string.
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					// Append 1 to previous max LCS till length l1 - 1, l2 - 1 of given strings
					// respectively.
					cache[i][j] = 1 + cache[i - 1][j - 1];
					continue;
				}

				// Case 1 : Substring of length l1 - 1, and l2 of respective strings (str1 and
				// str2)
				// Case 2 : Substring of length l1, and l2 - 1 of respective strings
				cache[i][j] = Math.max(cache[i - 1][j], cache[i][j - 1]);
			}
		}

		return cache[l1][l2];
	}
}
