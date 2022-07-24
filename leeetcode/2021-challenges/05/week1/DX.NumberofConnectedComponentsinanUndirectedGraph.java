/*
You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates
 that there is an edge between ai and bi in the graph.

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
https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
*/


class Solution {
    // approach: disjoint set with union path compression algorith.
    /**
    1. n points = n islands = n trees = n roots.
    2. With each edge added, check which island is e[0] or e[1] belonging to.
    3. If e[0] and e[1] are in same islands, do nothing.
    4. Otherwise, union two islands, and reduce islands count by 1.
    Bonus: path compression can reduce time by 50%.
 */
    // https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3880/
    public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n]; //disjoined set
        for(int i =0; i < n; i++) roots[i] = i;
        
        for(int[] edge : edges){
            int root1 = find(roots, edge[0]);
            int root2 = find(roots, edge[1]);
            
            if(root1 != root2){
                roots[root1] = root2;  // union
                n--;
            }
        }
        
        return n;
    }
    
    public int find(int[] roots, int edge){
        int oldEdge = edge;
        while(roots[edge] != edge){
            edge = roots[edge];
        }
        roots[oldEdge] = edge; //path optimization
        return edge;
    }
}