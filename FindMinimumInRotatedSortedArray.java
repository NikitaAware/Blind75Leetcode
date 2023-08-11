// 153. Find Minimum in Rotated Sorted Array
// Medium
// 11.4K
// 509
// Companies
// Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

// [4,5,6,7,0,1,2] if it was rotated 4 times.
// [0,1,2,4,5,6,7] if it was rotated 7 times.
// Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

// Given the sorted rotated array nums of unique elements, return the minimum element of this array.

// You must write an algorithm that runs in O(log n) time.

public class FindMinimumInRotatedSortedArray {
    int[] nums;

    FindMinimumInRotatedSortedArray(int[] nums) {
        this.nums = nums;
    }

    public void findMin() {
        int l = 0;
        if (nums.length == 1) {
            System.out.println(nums[0]);
            return;
        }
        int r = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (l < r) {
            // compare with left and right not mid + 1, mid - 1
            int mid = (l + r) / 2;
            if (mid == l || mid == r) {
                min = Math.min(nums[r], nums[l]);
                break;
            }
            if (nums[l] < nums[mid] && nums[l] < nums[r]) {
                min = nums[l];
                break;
            }
            if (nums[l] > nums[mid]) {
                r = mid;
            } else {
                l = mid;
            }

        }
        System.out.println(min);
    }
}
/**
 * Binary search variation
 * 3 4 5 6 1 2
 * mid - 2 if number to the right is greater than mid then check towards right
 * remaining 6 1 2
 * mid - 4 if number to right of the mid is greater and left of mid is also
 * greater then we found it (yayyyy)
 * duplicates
 * 3 4 5 2 1 1
 * 
 * 
 */