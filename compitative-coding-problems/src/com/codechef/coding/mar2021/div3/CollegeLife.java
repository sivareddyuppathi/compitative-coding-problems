package com.codechef.coding.mar2021.div3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollegeLife {

	public static void main(String[] args) {
		
		int[] arr = { 2, 1, 0,7,2 };
		// 2eggs-amlete; 3-chklets for milkshake 1-egg & 1-chklts for bar
//		System.out.println(solve(4,arr));;
//		int sum = needToPay(arr);
//		System.out.println(sum);
	}

	static int solve(int desired_result, int[] powers) {
		// Write your code here
		Map<Integer, List<Integer>> backup = new HashMap<>();
		int output = 0;

		for (int i = 0; i < powers.length; i++) {
			int first = powers[i];	
			for (int j = i + 1; j < powers.length; j++) {

				int second = powers[j];
				int max = Math.max(first, second);
				int min = Math.min(first, second);
				int out = max - min;
				if(out == desired_result) {
					return first+ second;
				}
				if (!backup.containsKey(out)) {
					List<Integer> li = new ArrayList<>();
					li.add(first);
					li.add(second);
					backup.put(out, li);
				}
			}
		}
		List<Integer> keys = new ArrayList<>(backup.keySet());
		int idx = 0;
		int dist = Math.abs(keys.get(0)-desired_result);
	       for(int key:keys) {
	           int c = Math.abs(key-desired_result);
	           if(c<dist) {
	               idx =key;
	               dist = c;
	           }
	       }
		List<Integer> ou = backup.get(keys.get(0));
		output = ou.get(0) + ou.get(1);
		return output;
	}

	private static int needToPay(int[] arr) {
		if (arr[1] <= arr[0] && arr[2] <= arr[0]) {
			return -1;
		}
		int sum =0;
		
		int noOfFriends = arr[0];
		
		int eggs = arr[1];
		int chocklets = arr[2];
			
		int omletCost = arr[3];
		int milkshakeCost = arr[4];
		int chacobarCost = arr[5];
		
		int temp = omletCost > milkshakeCost ? omletCost: milkshakeCost;	
		int small = chacobarCost < temp ? chacobarCost : temp;
		
		
		
//		while() {
//			
//		}
		return 0;
	}

}
