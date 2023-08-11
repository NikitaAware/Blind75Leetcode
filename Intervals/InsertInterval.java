// 57. Insert Interval
// Medium
// 8.8K
// 626
// Companies
// You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

// Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

// Return intervals after the insertion.
/**
 * Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
// solve this again
package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    int[][] intervals;
    int[] newInterval;

    public InsertInterval(int[][] intervals, int[] newInterval) {
        this.intervals = intervals;
        this.newInterval = newInterval;
    }

    public void insert() {
        // first add an interval and then merge it
        int[][] intervalsAfterAdding = new int[intervals.length + 1][2];
        intervalsAfterAdding[0] = newInterval;
        for (int i = 1; i < intervalsAfterAdding.length; i++) {
            intervalsAfterAdding[i] = intervals[i - 1];
        }
        // now merge them
        List<int[]> merged = new ArrayList<int[]>();
        // first sort the intervals by their start time
        Arrays.sort(intervalsAfterAdding, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        for (int[] currInterval : intervalsAfterAdding) {
            // if there are no intervals in merged intervals just add the interval also if
            // there is no overlap then also just add an interval
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < currInterval[0]) {
                merged.add(currInterval);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], currInterval[1]);
            }

        }
        for (int i = 0; i < merged.size(); i++) {
            System.out.println(merged.get(i)[0] + " " + merged.get(i)[1]);
        }
    }
}
/**
 * 
 * 4 8
 * 
 * 1 1
 * 2 5 - start newInterval[0] <= end of the interval
 * 6 7
 * 8 10 - end newInterval[1] <= start of the interval
 * 12 16
 * 
 */