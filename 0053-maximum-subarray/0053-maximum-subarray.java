// class Solution {
//     public int maxSubArray(int[] nums) {
        
//         int curMax = nums[0], max = nums[0];
        
//         for(int i=1; i< nums.length; i++) {
//             curMax = Math.max((curMax + nums[i]), nums[i]);
//             max = Math.max(curMax, max);
//         }
//         return max;
//     }
// }

class Solution {
    public int maxSubArray(int[] nums) {
        // need to fill in the dp table 
        
        // we can just fill in the dp table by itself since we are only returning our solution and not the list itself that contains the integers
        // either include the ith element or you don't
        // Opt(i) = 
        if(nums.length == 1) {
            return nums[0];
        }
        int max = nums[0]; // this is our default value
        // we are doing bottom up dynamic programming
        for(int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i-1] + nums[i], nums[i]);
            if(nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
        
    }
}