/*
Possible Bipartition
-----
Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

Each person may dislike some other people, and they should not go into the same group. 

Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

Return true if and only if it is possible to split everyone into two groups in this way.

 

Example 1:

Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]
Example 2:

Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Example 3:

Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false
 

Note:

1 <= N <= 2000
0 <= dislikes.length <= 10000
1 <= dislikes[i][j] <= N
dislikes[i][0] < dislikes[i][1]
There does not exist i != j for which dislikes[i] == dislikes[j].
*/

/**
Hint:

Think of graph, node coloring, and DFS.

Abstract model transformation:

Person <-> Node

P1 and P2 dislike each other <-> Node 1 and Node 2 share one edge, and they can be drawed with different two colors (i.e., for dislike relation)

If we can draw each dislike pair with different two colors, and keep the dislike relationship always, then there exists at least one possible bipartition.

 */
// not colored == 0, blue == 1, red == 1
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] colorTable = new int[N + 1];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : dislikes) {
            graph.computeIfAbsent(edge[0], l -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], l -> new ArrayList<>()).add(edge[0]);
        }
        for (int i = 1; i <= N; i++) {
            if (colorTable[i] == 0 && !dfs(graph, colorTable, i, 1)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(Map<Integer, List<Integer>> graph, int[] colorTable, int cur, int color) {
        colorTable[cur] = color;
        for (int next : graph.getOrDefault(cur, Collections.emptyList())) {
            if (colorTable[next] == color) {
                return false;
            }
            if (colorTable[next] == 0 && !dfs(graph, colorTable, next, -color)) {
                return false;
            }
        }
        return true;
    }
}

// this one runs a little faster
// same idea, -1 uncolored.. 0 and 1 colored
// optimized to return faster in case that node has been visited before

class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] groups = new int[N];
        Arrays.fill(groups,-1);
        ArrayList<Integer>[] adj = new ArrayList[N];
        for(int i = 0; i < N; i++){
            adj[i] = new ArrayList();
        }
        for(int[] p : dislikes){
            adj[p[0]-1].add(p[1] -1);
            adj[p[1]-1].add(p[0] -1);
        }
        
        for(int i = 0; i < N; i++){
            if(groups[i] == -1 && !dfs(adj, groups, i, 0)){
                return false;
            }
        }
        return true;
    }
    
    boolean dfs(ArrayList<Integer>[] adj, int[] groups, int v, int grp){
        if(groups[v] == -1) groups[v] = grp;
        else return groups[v] == grp;
        for(int n : adj[v]){
            if(!dfs(adj,groups, n, 1-grp)){
                return false;
            }
        }
        return true;
        
    }
}