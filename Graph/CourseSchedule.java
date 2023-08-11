// Medium
// 14.8K
// 587
// Companies
// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return true if you can finish all courses. Otherwise, return false.

// Example 1:

// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: true
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0. So it is possible.
// Example 2:

// Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
// Output: false
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
package Graph;

import java.util.HashSet;

public class CourseSchedule {
    int[][] prerequisites;
    int numCourses;
    int[][] directedGraph;

    public CourseSchedule(int[][] prerequisites, int numCourses) {
        this.prerequisites = prerequisites;
        this.numCourses = numCourses;
        this.directedGraph = new int[numCourses][numCourses];
        // create a graph to know the directed paths i.e to take course 0 you need to
        // take course zero so path is 1 -> 0 add 1 for path otherwise it is zero (by
        // default)
        for (int i = 0; i < prerequisites.length; i++) {
            directedGraph[prerequisites[i][1]][prerequisites[i][0]] = 1;
        }
        // if this graph contains a cycle i.e. there is a cyclic dependency then all courses won't be covered
    }

    public boolean isCyclic(int curr, HashSet<Integer> vis) {
        if (curr >= numCourses) {
            return false;
        }
        for (int i = 0; i < numCourses; i++) {
            // if there is a dependecy from curr to i but i was part of the previous dependency then there is a cycle
            if (directedGraph[curr][i] == 1 && vis.contains(i)) {
                return true;
            }
            if (directedGraph[curr][i] == 1) {
                vis.add(i);
                if (isCyclic(i, vis)) {
                    return true;
                }
                vis.remove(i);
                directedGraph[curr][i] = 0;
            }
        }
        return false;
    }

    public void isPossible() {
        // start from every course and check for the possible cycles
        for (int i = 0; i < numCourses; i++) {
            for (int j = 0; j < numCourses; j++) {
                if (directedGraph[i][j] == 1) {
                    HashSet<Integer> vis = new HashSet<Integer>();
                    vis.add(i);
                    vis.add(j);
                    if (isCyclic(j, vis)) {
                       System.out.println("false");
                       return;
                    }
                }
            }
        }
        System.out.println("true");
    }
    
}
