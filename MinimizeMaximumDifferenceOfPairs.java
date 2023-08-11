// 2616. Minimize the Maximum Difference of Pairs
// Medium
// 998
// 103
// Companies
// You are given a 0-indexed integer array nums and an integer p. Find p pairs of indices of nums such that the maximum difference amongst all the pairs is minimized. Also, ensure no index appears more than once amongst the p pairs.

// Note that for a pair of elements at the index i and j, the difference of this pair is |nums[i] - nums[j]|, where |x| represents the absolute value of x.

// Return the minimum maximum difference among all p pairs. We define the maximum of an empty set to be zero.

import java.util.Arrays;

public class MinimizeMaximumDifferenceOfPairs {
    public int minimizeMax(int[] nums, int p) {
        if (p == 0) {
            return 0;
        }
        Arrays.sort(nums);

        int l = 0; // minimum possible difference
        int r = nums[nums.length - 1] - nums[0]; // max possible difference

        while (l < r) {
            int mid = (l + r) / 2;
            int count = 0; // check if we can have p pairs that have differences less than mid if yes move
                           // to left otherwise move to right when we have l == r that means we will have
                           // exact p pairs and that is the min possible value of mid
            // point to note here is that mid is not the exact value neither do we need the exact value we just need a minimum value such that  p pairs with difference less than that exist
            // so even if we have p pairs less than that value we keep checking towards left
            // in the end we will have the lowest possible value that has p pairs with a difference less than that
            for (int i = 1; i < nums.length && count < p; i++) {
                if (nums[i] - nums[i - 1] <= mid) {
                    // the number is less than the mid so we can have it in our list
                    count++;
                    i++;
                }
            }
            if (count >= p) {
                // even if we found exact p values there can be a value towards left that has p values less than that number 
                // we have more than p possible numbers that are greater than mid so we can move
                // to left
                r = mid;
            } else {
                l = mid + 1; // if we are at a situation where we will have p possible values 
            }
        }
        return l;
    }
}
