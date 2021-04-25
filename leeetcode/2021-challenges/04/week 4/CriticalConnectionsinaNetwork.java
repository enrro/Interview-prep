/*
There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network where connections[i] = [a, b] represents a connection between servers a and b. Any server can reach any other server directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some server unable to reach some other server.

Return all critical connections in the network in any order.

 

Example 1:



Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.
 

Constraints:

1 <= n <= 10^5
n-1 <= connections.length <= 10^5
connections[i][0] != connections[i][1]
There are no repeated connections.
https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/596/week-4-april-22nd-april-28th/3719/
*/
class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // use a timestamp, for each node, check the samllest timestamp that can reach from the node
        // construct the graph first
        List[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (List<Integer> conn : connections) {
            int from = conn.get(0);
            int to = conn.get(1);
            graph[from].add(to);
            graph[to].add(from);
        }
        
        int[] timestamp = new int[n]; // an array to save the timestamp that we meet a certain node
        
        // for each node, we need to run dfs for it, and return the smallest timestamp in all its children except its parent
        List<List<Integer>> criticalConns = new ArrayList<>();
        dfs(graph, timestamp, 0, -1, criticalConns);
        return criticalConns;
    }
    
    int T = 1;
    // return the minimum timestamp it ever visited in all the neighbors
    private int dfs(List[] graph, int[] timestamp, int cur, int parent, List<List<Integer>> criticalConns) {
        if (timestamp[cur] != 0) return timestamp[cur];
        timestamp[cur] = T++;

        int minTimestamp = Integer.MAX_VALUE;
        for (int neighbor : (List<Integer>) graph[cur]) {
            if (neighbor == parent) continue; // no need to check the parent
            int neighborTimestamp = dfs(graph, timestamp, neighbor, cur, criticalConns);
            minTimestamp = Math.min(minTimestamp, neighborTimestamp);
        }
        
        if (minTimestamp >= timestamp[cur]) {
            if (parent >= 0) criticalConns.add(Arrays.asList(parent, cur));
        }
        return Math.min(timestamp[cur], minTimestamp);
    }
}