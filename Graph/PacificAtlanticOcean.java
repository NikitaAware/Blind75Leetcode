// 417. Pacific Atlantic Water Flow
// Medium
// 6.7K
// 1.3K
// Companies
// There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

// The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

// The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

// Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.

// Example 1:

// Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
// Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
// Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
// [0,4]: [0,4] -> Pacific Ocean 
//        [0,4] -> Atlantic Ocean
// [1,3]: [1,3] -> [0,3] -> Pacific Ocean 
//        [1,3] -> [1,4] -> Atlantic Ocean
// [1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean 
//        [1,4] -> Atlantic Ocean
// [2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean 
//        [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
// [3,0]: [3,0] -> Pacific Ocean 
//        [3,0] -> [4,0] -> Atlantic Ocean
// [3,1]: [3,1] -> [3,0] -> Pacific Ocean 
//        [3,1] -> [4,1] -> Atlantic Ocean
// [4,0]: [4,0] -> Pacific Ocean 
//        [4,0] -> Atlantic Ocean
// Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.
// Example 2:

// Input: heights = [[1]]
// Output: [[0,0]]
// Explanation: The water can flow from the only
package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticOcean {
    int[][] heights;
    int rMax;
    int cMax;
    List<List<Integer>> res;
    List<List<Integer>> pacific;
    List<List<Integer>> atlantic;

    public PacificAtlanticOcean(int[][] heights) {
        this.heights = heights;
        this.rMax = heights.length - 1;
        this.cMax = heights[0].length - 1;
        this.res = new ArrayList<List<Integer>>();
        this.pacific = new ArrayList<List<Integer>>();
        this.atlantic = new ArrayList<List<Integer>>();
    }

    public void reachable() {
        // check the elements that can reach pacific ocean
        // check the elements than can reach Atlantic ocean
        // the elements that are common to both are our result set
        // use DFS to traverse all the elements -1 to all the traversed elements to
        // avoid using a HashSet

        // create two height arrays to track pacific and atlantic

        int[][] pacificHeights = heights.clone();
        int[][] atlanticHeights = heights.clone();

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                // reverse track from the nodes that are in direct contact with pacific and
                // atlantic ocean
                // pacific
                if (i == 0 || j == 0) {
                    if (pacificHeights[i][j] != -1) { // already visited
                        List<List<Integer>> islands = new ArrayList<List<Integer>>();
                        List<Integer> tmp = new ArrayList<Integer>(Arrays.asList(i, j));
                        islands.add(tmp);
                        DFS(i, j, islands, pacificHeights);
                        pacific.addAll(islands);
                    }
                }

                // in direct contact with atlantic
                if (j == cMax || i == rMax) {
                    if (atlanticHeights[i][j] != -1) { // already visited
                        List<List<Integer>> islands = new ArrayList<List<Integer>>();
                        List<Integer> tmp = new ArrayList<Integer>(Arrays.asList(i, j));
                        islands.add(tmp);
                        DFS(i, j, islands, atlanticHeights);
                        atlantic.addAll(islands);
                    }
                }
            }
        }
        System.out.println("pacific:");
        for (int i = 0; i < pacific.size(); i++) {
            System.out.println("(" + pacific.get(i).get(0) + ", " + pacific.get(i).get(1) + ")");
        }
        System.out.println("atlantic:");
        for (int i = 0; i < atlantic.size(); i++) {
            System.out.println("(" + atlantic.get(i).get(0) + ", " + atlantic.get(i).get(1) + ")");
        }

    }

    public void DFS(int r, int c, List<List<Integer>> islands, int[][] cHeights) {

        if (r > rMax || c > cMax || r < 0 || c < 0) {
            return;
        }
        // if the next cell is valid and height is less than or equal the current cell
        // water can flow from the current cell to the next cell
        // next cells can be top, bottom, left or right
        // -1s's are visited
        if (r + 1 <= rMax && cHeights[r + 1][c] != -1 && cHeights[r + 1][c] >= cHeights[r][c]) {
            List<Integer> tmp = new ArrayList<Integer>(Arrays.asList(r + 1, c));
            islands.add(tmp);
            cHeights[r + 1][c] = -1;
            DFS(r + 1, c, islands, cHeights);
        }
        if (r - 1 >= 0 && cHeights[r - 1][c] != -1 && cHeights[r - 1][c] >= cHeights[r][c]) {
            List<Integer> tmp = new ArrayList<Integer>(Arrays.asList(r - 1, c));
            islands.add(tmp);
            cHeights[r - 1][c] = -1;
            DFS(r - 1, c, islands, cHeights);
        }
        if (c - 1 >= 0 && cHeights[r][c - 1] != -1 && cHeights[r][c - 1] >= cHeights[r][c]) {
            List<Integer> tmp = new ArrayList<Integer>(Arrays.asList(r, c - 1));
            islands.add(tmp);
            cHeights[r][c - 1] = -1;
            DFS(r, c - 1, islands, cHeights);
        }
        if (c + 1 <= cMax && cHeights[r][c + 1] != -1 && cHeights[r][c + 1] >= cHeights[r][c]) {
            List<Integer> tmp = new ArrayList<Integer>(Arrays.asList(r, c + 1));
            islands.add(tmp);
            cHeights[r][c + 1] = -1;
            DFS(r, c + 1, islands, cHeights);
        }
    }
}
