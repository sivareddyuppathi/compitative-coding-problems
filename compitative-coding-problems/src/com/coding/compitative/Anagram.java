package com.coding.compitative;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		char str1[] = { 't', 'e', 's', 't' };
		char str2[] = { 't', 't', 'e', 'w' };
//      Aproch-1: O(nLogn) & O(1)
		boolean isAnagram = checkAnagramUsingSorting(str1, str2);

//      Aproch-2 (Count characters) 
		boolean isAnagram1 = checkAnagramByCharCount2Arrays(str1, str2);
	}

	private static boolean checkAnagramByCharCount2Arrays(char[] str1, char[] str2) {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean checkAnagramUsingSorting(char[] str1, char[] str2) {

		if (str1.length != str2.length)
			return false;

		Arrays.sort(str1);
		Arrays.sort(str2);

		for (int i = 0; i < str1.length; i++) {
			if (str1[i] != str2[i])
				return false;
		}

		return true;
	}

}
