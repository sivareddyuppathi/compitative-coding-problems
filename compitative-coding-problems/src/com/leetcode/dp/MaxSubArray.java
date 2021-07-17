package com.leetcode.dp;

//Kadane's algorithm...
public class MaxSubArray {
	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray(nums));
		System.out.println(maxSubArray2(nums));
	}

	//O(1)-> space & O(n)-> time 
	public static int maxSubArray(int[] nums) {
		int max = nums[0];
		int sum = 0;

		for (int i = 0; i < nums.length; i++) {
			sum = Math.max(sum + nums[i], nums[i]);
			max = Math.max(max, sum);
		}
		return max;	
	}
	
	//O(n)-> space & O(n)-> time
	public static int maxSubArray2	(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];
        
        for(int i = 1; i < n; i++){
//        	dp[i] = Math.max(A[i] + dp[i - 1] , A[i]);
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        
        return max;
}
}
