// 435. Non-overlapping Intervals
// Medium
// 7.3K
// 189
// Companies
// Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

// Example 1:

// Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
// Output: 1
// Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
// Example 2:

// Input: intervals = [[1,2],[1,2],[1,2]]
// Output: 2
// Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
// Example 3:

// Input: intervals = [[1,2],[2,3]]
// Output: 0
// Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

        List<int[]> res = new ArrayList<int[]>();
        int cnt = 0;
        for (int[] interval : intervals) {
            if (res.size() == 0 || res.get(res.size() - 1)[1] <= interval[0]) {
                res.add(interval);
            } else {
                // if two intervals are overlapping keep the one whose end is lesser
                // that would make sure that the overlapping region with the other remaining
                // intervals will be lesser
                // same for the meeting rooms II as we will only need extra meeting rooms for
                // the overlapping ones
                // so choose to attend meetings with the earlier ending time first
                // In the end we will need 1 room for the non overlapping ones and rooms equal
                // to the count for the overlapping ones
                if (interval[1] < res.get(res.size() - 1)[1]) {
                    res.get(res.size() - 1)[0] = interval[0];
                    res.get(res.size() - 1)[1] = interval[1];
                }
                cnt++;
            }
        }
        return cnt;
    }
}
