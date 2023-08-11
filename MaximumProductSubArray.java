/**
 * 152. Maximum Product Subarray
 * Medium
 * 16.8K
 * 513
 * Companies
 * Given an integer array nums, find a
 * subarray
 * that has the largest product, and return the product.
 * 
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 * 
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaximumProductSubArray {
    int[] nums;

    MaximumProductSubArray(int[] nums) {
        this.nums = nums;
    }

    public void maxProductSubArray() {
        // Kadane's algorithm
        int result = Integer.MIN_VALUE;

        int prefix = 1;
        int[] prefixArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (prefix == 0) { // cases like 2 0 3 4 prefix of 4 will be zero so when at three if the prefix
                               // becomes 0 consider it as 1 and start from 3. so prefix of 4 will be 12 same
                               // is applicable for the postfix
                prefix = 1;
            }
            prefix = prefix * nums[i];
            prefixArr[i] = prefix;
        }

        int[] postfixArr = new int[nums.length];
        int postFix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (postFix == 0) {
                postFix = 1;
            }
            postFix = postFix * nums[i];
            postfixArr[i] = postFix;
        }

        for (int i = 0; i < nums.length; i++) {
            result = Math.max(result, Math.max(prefixArr[i], postfixArr[i]));
        }
        System.out.println(result);
    }

}
/**
 * Kadane's Algorithm prefix + postFix Variation
 * 2 3 -2 4
 * 2 6 -12 -24 -> prefix product
 * -48 -24 -8 4 -> postfix product
 * 2 6 -12 4 - maximum (prefix, postfix)
 * 6 - final result
 */