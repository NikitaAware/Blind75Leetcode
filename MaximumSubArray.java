// 53. Maximum Subarray
// Medium
// 31K
// 1.3K
// Companies
// Given an integer array nums, find the 
// subarray
//  with the largest sum, and return its sum.

// Example 1:

// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.
// Example 2:

// Input: nums = [1]
// Output: 1
// Explanation: The subarray [1] has the largest sum 1.
// Example 3:

// Input: nums = [5,4,-1,7,8]
// Output: 23
// Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

public class MaximumSubArray {
    int[] nums;

    MaximumSubArray(int[] nums) {
        this.nums = nums;
    }

    public void maxSubarray() {
        /**
         * either choose prev + nums[i] or nums[i]
         * 0 prev Integer.MIN_VALUE max = -2
         * 1 prev -2 prev + nums[i] = -1 nums[i] = 1 choose nums[i] max = 1
         * 2 prev 1 prev + nums[i] = -2 nums[i] = -3 choose choose prev + nums[i] max =
         * 1
         * 3 prev -2 prev + nums[i] = 2 nums[i] = 4 choose choose nums[i] max = 4
         * 4 prev 4 prev + nums[i] = 3 nums[i] = -1 choose choose prev + nums[i] max = 4
         * 5 prev 3 prev + nums[i] = 5 nums[i] = 2 choose choose prev + nums[i] max = 5
         * 6 prev 5 prev + nums[i] = 6 nums[i] = 1 choose choose prev + nums[i] max = 6
         * 7 prev 6 prev + nums[i] = 1 nums[i] = -5 choose choose prev + nums[i] max = 6
         * 8 prev 1 prev + nums[i] = 5 nums[i] = 4 choose choose prev + nums[i] max = 6
         */
        int prevSum = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // Kadane's Algorithm
            prevSum = Math.max(nums[i], prevSum + nums[i]);
            res = Math.max(prevSum, res);
        }
        System.out.println(res);
    }
}