package com.coding.compitative;

import java.util.Scanner;

public class WayTooLongWords_71A {

	

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int num = input.nextInt(); // How many no of words will you enter

		for (int i = 0; i <= num; i++) {
			String word = input.next(); // Enter the word..

			if (word.length() > 10) {
				System.out.print(word.charAt(0));
				System.out.print(word.length() - 2);
				System.out.println(word.charAt(word.length() - 1));
			} else {
				System.out.println(word);
			}
		}
		input.close();
	}
}
