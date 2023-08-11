// 15. 3Sum
// Medium
// 27.4K
// 2.5K
// Companies
// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets.

// Example 1:

// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Explanation: 
// nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
// The distinct triplets are [-1,0,1] and [-1,-1,2].
// Notice that the order of the output and the order of the triplets does not matter.
// Example 2:

// Input: nums = [0,1,1]
// Output: []
// Explanation: The only possible triplet does not sum up to 0.
// Example 3:

// Input: nums = [0,0,0]
// Output: [[0,0,0]]
// Explanation: The only possible triplet sums up to 0.

// Constraints:

// 3 <= nums.length <= 3000
// -105 <= nums[i] <= 105

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    int[] nums;
    List<List<Integer>> res;

    ThreeSum(int[] nums) {
        // best way to solve this problem is to call two sum for every unique element of
        // sorted nums (ignore if nums[i] == nums[i - 1] they will yield the same
        // result)
        this.nums = nums;
        Arrays.sort(nums);
        this.res = new ArrayList<List<Integer>>();
    }

    public void threeSumFunction(int cnt, int curr, int sum, ArrayList<Integer> threeNums) {
        if (cnt == 3 && sum == 0) {
            res.add(threeNums);
            return;
        }
        if (curr >= nums.length || cnt == 3) {
            return;
        }

        ArrayList<Integer> newList = (ArrayList<Integer>) threeNums.clone();
        newList.add(nums[curr]);
        threeSumFunction(cnt + 1, curr + 1, sum + nums[curr], newList); // add current number
        threeSumFunction(cnt, curr + 1, sum, (ArrayList<Integer>) threeNums.clone()); // do not add curr number

    }

    public void threeSumCombinations() {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(nums[i]);
            threeSumFunction(1, i + 1, nums[i], list);
        }
        for (int i = 0; i < res.size(); i++) {
            List<Integer> combo = res.get(i);
            System.out.println(combo.get(0) + " " + combo.get(1) + " " + combo.get(2));
        }
    }
}
