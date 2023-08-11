// There is an integer array nums sorted in ascending order (with distinct values).

// Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

// Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

// You must write an algorithm with O(log n) runtime complexity.

// Example 1:

// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4
// Example 2:

// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1
// Example 3:

// Input: nums = [1], target = 0
// Output: -1

public class SearchInRotatedSortedArray {
    int[] nums;
    int target;

    SearchInRotatedSortedArray(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
    }

    public void search() {
        // first find the smallest element in the array, that would be the separation of
        // two sorted arrays 0 to smallestIdx, smallestIdx + 1, nums.length - 1 and we
        // can use binary search to search in both the arrays
        int smallestIdx = findMin();
        int res = binSearch(0, smallestIdx - 1);
        // System.out.println(smallestIdx);
        if (res != -1) {
            System.out.println(res);
            return;
        }
        res = binSearch(smallestIdx, nums.length - 1);
        System.out.println(res);
    }

    public int binSearch(int l, int r) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public int findMin() {
        int l = 0;
        if (nums.length == 1) {
            return 0;
        }
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[l] && nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        // it eliminates all the other numbers
        return l;
    }
}
/**
 * 
 * 4,5,6,7,0,1,2,3
 * 7 0 1 2 3
 * 
 */
