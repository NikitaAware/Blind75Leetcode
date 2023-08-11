// 300. Longest Increasing Subsequence
// Medium
// 18.3K
// 345
// Companies
// Given an integer array nums, return the length of the longest strictly increasing 
// subsequence
// .

// Example 1:

// Input: nums = [10,9,2,5,3,7,101,18]
// Output: 4
// Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
// Example 2:

// Input: nums = [0,1,0,3,2,3]
// Output: 4
// Example 3:

// Input: nums = [7,7,7,7,7,7,7]
// Output: 1

import java.util.HashMap;

public class LongestIncreasingSubsequence {
    int[] nums;
    int res;
    HashMap<Integer, Integer> map;

    LongestIncreasingSubsequence(int[] nums) {
        this.nums = nums;
        this.res = Integer.MIN_VALUE;
        this.map = new HashMap<Integer, Integer>();
    }

    int findLongest(int currIdx, int cnt) {
        res = Math.max(res, cnt);
        if (map.containsKey(currIdx)) {
            int totCnt = map.get(currIdx) + cnt;
            res = Math.max(res, totCnt);
            return totCnt;
        }
        if (currIdx >= nums.length - 1) {
            res = Math.max(res, cnt);
            return cnt;
        }
        int tot = cnt;
        for (int i = currIdx + 1; i < nums.length; i++) {
            if (nums[i] > nums[currIdx]) {
                int tmp = findLongest(i, cnt + 1);
                map.put(i, tmp - (cnt + 1));
                tot = Math.max(tot, tmp);
            }
        }
        map.put(currIdx, tot - cnt);
        res = Math.max(res, tot);
        return tot;
    }

    public int lengthOfLIS() {
        for (int i = 0; i < nums.length; i++) {
            findLongest(i, 1);
        }

        System.out.println(map);
        return res;
    }

    public void longestSubSeqLen() {
        System.out.println(lengthOfLIS());
    }
}
