/**
 *
leetcode premium question found in an article


Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

Example 1:

Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
Output: true
Example 2:

Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
Output: false
Before solving the problem, we have to know the definitions.

Tree vs Graph
A tree is a special undirected graph. It satisfies two properties

It is connected
It has no cycle.
 * 
 */
package Graph;

import java.util.HashSet;

public class GraphValidTree {

    int[][] edges;
    int[][] graph;

    public GraphValidTree(int[][] edges, int n) {
        this.edges = edges;
        // build a graph from edges
        this.graph = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]][edges[i][1]] = 1;
        }
    }

    public void isValidTree() {
        if (edges.length == 0) {
            System.out.println("VALID");
            return;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        if (DFS(edges[0][0], set) && set.size() == graph.length) {
            System.out.println("VALID");
            return;
        }
        System.out.println("INVALID");
    }

    public boolean DFS(int curr, HashSet<Integer> vis) {
        vis.add(curr);
        for (int i = 0; i < graph.length; i++) {
            if (graph[curr][i] == 1) { // edge is present
                if (vis.contains(i)) {
                    return false; // cycle
                } else {
                    vis.add(i);
                    if (!DFS(i, vis)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

/**
 * 
 * 
 * 0 - 1 - 2 - 3
 */