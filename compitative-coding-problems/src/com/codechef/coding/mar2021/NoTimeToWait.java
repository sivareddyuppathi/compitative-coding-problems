package com.codechef.coding.mar2021;

import java.util.stream.Stream;

public class NoTimeToWait {
	public static void main(String[] args) {
		
		Stream<Integer> s = Stream.iterate(5, n->n+2).limit(5);
		s.forEach(System.out::println);
//		int[] arr = { 2, 6, 3 };
//		int[] a = { 1, 2 };
//
//		String isTimeEnogh = isTimeEnoghToSolveProblem(arr, a);
//		System.out.println(isTimeEnogh);
	}

	private static String isTimeEnoghToSolveProblem(int[] arr, int[] a) {

		int noOFTimeZones = arr[0];
		int neededHours = arr[1];
		int hoursLeft = arr[2];

		for (int i = 0; i < noOFTimeZones; i++) {
			int havingHours = hoursLeft + a[i];
			if (havingHours >= neededHours)
				return "YES";
		}

		return "NO";
	}
}
