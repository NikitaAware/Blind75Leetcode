/*
 * 945. Minimum Increment to Make Array Unique
Medium
1.7K
53
Companies
You are given an integer array nums. In one move, you can pick an index i where 0 <= i < nums.length and increment nums[i] by 1.

Return the minimum number of moves to make every value in nums unique.

The test cases are generated so that the answer fits in a 32-bit integer.

 

Example 1:

Input: nums = [1,2,2]
Output: 1
Explanation: After 1 move, the array could be [1, 2, 3].
Example 2:

Input: nums = [3,2,1,2,1,7]
Output: 6
Explanation: After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
 */

package Heap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class MinimumIncrementToMakeArrayUnique {
    int[] nums;

    public MinimumIncrementToMakeArrayUnique(int[] nums) {
        this.nums = nums;
    }

    // approach
    // 1. store duplicates in a priority queue so that we will have them sorted
    // 2. find minimum of the numbers present
    // 3. try to set the lowest number from the priority queue to the lowest number
    // that does not exist in the array
    // 4. with the third step you reduce the difference between the number and the
    // number to which we want to set. In the end you are decreasing the steps
    public int minIncrementForUnique() {
        PriorityQueue<Integer> duplicates = new PriorityQueue<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > 1) {
                // duplicate
                duplicates.add(nums[i]);
            }
            min = Math.min(nums[i], min);
        }
        int cnt = 0;
        while (true) {
            if (duplicates.isEmpty()) {
                break;
            }
            int smallestDuplicate = duplicates.peek();
            if (!map.containsKey(min) && smallestDuplicate < min) {
                cnt = cnt + (min - smallestDuplicate);
                duplicates.poll();
            }
            min++;
        }
        return cnt;
    }
}
