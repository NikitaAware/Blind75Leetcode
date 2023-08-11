// 128. Longest Consecutive Sequence
// Medium
// 17.5K
// 767
// Companies
// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

// You must write an algorithm that runs in O(n) time.

import java.util.HashSet;

public class LongestConsecutiveSequence {
    int[] nums;

    LongestConsecutiveSequence(int[] nums) {
        this.nums = nums;
    }

    public int longestConsecutive() {
        // this solution is order of n as we are not visiting any element twice. we
        // maintained a hash set to track the elements that are
        // already visited
        if (nums.length == 0) {
            return 0;
        }
        int smallest = Integer.MAX_VALUE; // to set the first element of the queue
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            smallest = Math.min(smallest, nums[i]);
        }
        HashSet<Integer> vis = new HashSet<Integer>();
        int res = 1;
        for (int num : set) {
            if (vis.contains(num)) { // to visit each number only once
                continue;
            }
            int cnt = 1;
            int i = 1;
            boolean l = true;
            boolean r = true;
            while (true) {
                if (!l && !r) {
                    break;
                }
                if (!set.contains(num - i) && !set.contains(num + i)) { // both greater and smaller numbers don't exist
                    break;
                }
                if (set.contains(num - i) && l) {
                    cnt++;
                    vis.add(num - i);
                } else {
                    l = false; // left chain broke
                }
                if (set.contains(num + i) && r) {
                    cnt++;
                    vis.add(num + i);
                } else {
                    r = false; // right chain broke
                }
                i++;
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}
