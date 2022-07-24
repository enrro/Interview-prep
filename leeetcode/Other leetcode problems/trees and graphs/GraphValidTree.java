/**
You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.

Return true if the edges of the given graph make up a valid tree, and false otherwise.

 

Example 1:


Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
Output: true
Example 2:


Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
Output: false
 

Constraints:

1 <= n <= 2000
0 <= edges.length <= 5000
edges[i].length == 2
0 <= ai, bi < n
ai != bi
There are no self-loops or repeated edges.

https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3910/
 */


/**
Recall that a graph, G, is a tree iff the following two conditions are met:

G is fully connected. In other words, for every pair of nodes in G, there is a path between them.
G contains no cycles. In other words, there is exactly one path between each pair of nodes in G.

 */
 class Solution {
    public boolean validTree(int n, int[][] edges) {
        // initialize n isolated islands
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        
        // perform union find
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            System.out.println("x: " + x + " y: " + y);
            
            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) return false;
            
            // union
            nums[x] = y;
        }
        
        return edges.length == n - 1;
    }
    
    // if no parent node found then hi is the parent
    int find(int nums[], int i) {
        if (nums[i] == -1) return i;
        nums[i] =  find(nums, nums[i]); // path compresion
        return nums[i];
    }
}

/**
MORE COMMENTS!
Nice solution! I assume the origin of this idea is Krusal's algorithm for Minimum Spanning Tree problem.

MST-KRUSKAL(G,w)
1  A = empty
2  for each vertex v in G.V
3      MAKE-SET(v)
4  sort the edges of G.E into non-decreasing order by weight w
5  for each edge (u,v) in G.E, taken in non-decreasing order by weight
6      if FIND-SET(u) != FIND-SET(v)
7          A = A + {(u,v)}
8          UNION(u,v)
9  return A
As mentioned in CLRS: "The loop checks, for each edge (u, v), whether the endpoints u and belong to the same tree. 
If they do, then the edge (u, v) cannot be added to the forest without creating a cycle, and the edge is discarded. 
Otherwise, the two vertices belong to different trees."

    public boolean validTree(int n, int[][] edges) {
        int[] forest = new int[n];
        for (int i = 0; i < n; i++) forest[i] = i;
        
        for (int[] e : edges) {
            int tree1 = find(forest, e[0]);
            int tree2 = find(forest, e[1]);
            if (tree1 == tree2) return false; // found cycle!
            forest[tree1] = tree2;
        }
        return edges.length == n - 1; // connected
    }
    
    private int find(int[] forest, int v) { // Comparess path
        if (forest[v] != v) forest[v] = find(forest, forest[v]);
        return forest[v];
    }
But how to check if graph is connected? The Tree section of appendix in CLRS gives practical properties (item 5 is what we want):

"Theorem B.2 (Properties of free trees) - free tree means acyclic, connected, undirected graph.
Let G = (V,E) be an undirected graph. The following statements are equivalent.

1. G is a free tree.
2. Any two vertices in G are connected by a unique simple path.
3. G is connected, but if any edge is removed from E, the resulting graph is disconnected.
4. G is connected, and |E| = |V| - 1.
5. G is acyclic, and |E| = |V| - 1.
6. G is acyclic, but if any edge is added to E, the resulting graph contains a cycle.

 */