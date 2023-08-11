/**
 * Meeting Rooms II
Medium
Given an array of meeting time intervals consisting of start and end times[[s1,e1],[s2,e2],...](si< ei), find the minimum number of conference rooms required.
Example 1:
Input:
[[0, 30],[5, 10],[15, 20]]
Output:
 2
Example 2:
Input:
 [[7,10],[2,4]]
​
Output:
 1
 */
package Intervals;

public class MeetingRoomsII {
    int[][] intervals;
    public MeetingRoomsII(int[][] intervals) {
        this.intervals = intervals;
    }
    public void requiredRooms() {
        // explained the logic in the non-overlapping intervals question
        NonOverlappingIntervals nonOverlappingIntervals = new NonOverlappingIntervals();
        int res = nonOverlappingIntervals.eraseOverlapIntervals(intervals) + 1;
        System.out.println(res);
    }
}
