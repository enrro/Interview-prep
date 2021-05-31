/*
You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.

Return the number of connected components in the graph.

 

Example 1:


Input: n = 5, edges = [[0,1],[1,2],[3,4]]
Output: 2
Example 2:


Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
Output: 1
 

Constraints:

1 <= n <= 2000
1 <= edges.length <= 5000
edges[i].length == 2
0 <= ai <= bi < n
ai != bi
There are no repeated edges.
*/

class Solution {
    //https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3727/discuss/516491/Java-Union-Find-DFS-BFS-Solutions-Complexity-Explain-Clean-code
    // approach, union path compression algorith.
    public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
        for(int i = 0; i < n; i++) roots[i] = i; 

        for(int[] e : edges) {
            int root1 = find(roots, e[0]);
            int root2 = find(roots, e[1]);
            System.out.println("root1: " + root1 + " root2: "+  root2);
            if(root1 != root2) {      
                roots[root1] = root2;  // union
                n--;
            }
        }
        return n;
    }
    
    public int find(int[] roots, int id) {
        while(roots[id] != id) {
            System.out.println("roots[id] != id " + (roots[id] != id) );
            roots[id] = roots[roots[id]];  // optional: path compression
            id = roots[id];
        }
        return id;
    }
}