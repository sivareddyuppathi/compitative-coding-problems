package com.leetcode.dp;

public class LongestCommonSubSequence {

	public static void main(String[] args) {
		String str1 = "abcde";
		String str2 = "ace";

		System.out.println(lcsDP(str1, str2));
		System.out.println(lcsDP_Simplified(str1, str2));
		// Recursive
		System.out.println(lcsRecu(str1, str2));
	}

	private static int lcsRecuHelper(String word1, String word2) {
		if (word1.isBlank() || word2.isBlank())
			return 0;
		if (word1.charAt(0) == word2.charAt(0))
			return 1 + lcsRecuHelper(word1.substring(1), word2.substring(1));
		return Math.max(lcsRecuHelper(word1, word2.substring(1)), lcsRecuHelper(word1.substring(1), word2));
	}


	private static int lcsRecu(String word1, String word2) {
		int n1 = word1.length(), n2 = word2.length();
		if (n1 == 0 || n2 == 0)
			return 0;
		if (word1.charAt(n1 - 1) == word2.charAt(n2 - 1))
			return 1 + lcsRecuHelper(word1.substring(0, n1 - 1), word2.substring(0, n2 - 1));
		return Math.max(lcsRecuHelper(word1, word2.substring(0, n2 - 1)),
				lcsRecuHelper(word1.substring(0, n1 - 1), word2));
	}

	private static int lcsDP_Simplified(String text1, String text2) {
		int a = text1.length(), b = text2.length();
		int[][] dp = new int[a + 1][b + 1];
		for (int i = 1; i <= a; i++) {
			for (int j = 1; j <= b; j++) {
				dp[i][j] = ((text1.charAt(i - 1) == text2.charAt(j - 1)) ? dp[i - 1][j - 1] + 1
						: Math.max(dp[i][j - 1], dp[i - 1][j]));
			}
		}
		return dp[a][b];
	}

	private static int lcsDP(String str1, String str2) {
		int l1 = str1.length();
		int l2 = str2.length();

		int[][] cache = new int[l1 + 1][l2 + 1];

		for (int i = 1; i <= l1; i++) {
			for (int j = 1; j <= l2; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					cache[i][j] = 1 + cache[i - 1][j - 1];
					continue;
				}
				cache[i][j] = Math.max(cache[i - 1][j], cache[i][j - 1]);
			}
		}

		return cache[l1][l2];
	}
}
