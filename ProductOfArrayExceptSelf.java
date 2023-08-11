// 238. Product of Array Except Self
// Medium
// 19K
// 1K
// Companies
// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

// You must write an algorithm that runs in O(n) time and without using the division operation.

// Example 1:

// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]
// Example 2:

// Input: nums = [-1,1,0,-3,3]
// Output: [0,0,9,0,0]
public class ProductOfArrayExceptSelf {
    int[] nums;

    ProductOfArrayExceptSelf(int[] nums) {
        this.nums = nums;
    }

    public void productExceptSelf() {
        // for finding it without using division operator we will need to find the
        // prefix and suffix product of each element
        int[] prefix = new int[nums.length];
        int prefixProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            prefix[i] = prefixProduct;
            prefixProduct = prefixProduct * nums[i];
        }
        int[] postFix = new int[nums.length];
        int postFixProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            postFix[i] = postFixProduct;
            postFixProduct = postFixProduct * nums[i];
        }
        // final result
        System.out.println("result: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(prefix[i] * postFix[i] + " ");
        }
    }

}
