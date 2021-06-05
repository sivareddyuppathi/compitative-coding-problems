package com.leetcode.dp;

import java.util.Arrays;

//https://leetcode.com/explore/featured/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3766/
public class MaxAreaOfPeaceOfCake {
	public static void main(String[] args) {
		int h = 5;
		int w = 4;
		int[] horizontalCuts = { 1, 2, 4 };
		int[] verticalCuts = { 1, 3 };
		int result = maxArea(h, w, horizontalCuts, verticalCuts);
		System.out.println(result);
	}

	public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

		Arrays.sort(horizontalCuts);
		Arrays.sort(verticalCuts);

		int maxH = horizontalCuts[0];

		for (int i = 1; i < horizontalCuts.length; i++) {
			maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i - 1]);
		}
		maxH = Math.max(maxH, h - horizontalCuts[horizontalCuts.length - 1]);

		int maxW = verticalCuts[0];
		for (int i = 1; i < verticalCuts.length; i++) {
			maxW = Math.max(maxW, verticalCuts[i] - verticalCuts[i - 1]);
		}
		maxW = Math.max(maxW, w - verticalCuts[verticalCuts.length - 1]);

		return (int) (((long) maxH * (long) maxW) % 1000000007);
	}
}
