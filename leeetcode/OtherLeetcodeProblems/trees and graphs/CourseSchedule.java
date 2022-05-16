/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 105
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
https://leetcode.com/explore/interview/card/amazon/78/trees-and-graphs/2983/
*/

class Solution {
    //https://www.youtube.com/watch?v=iaaObeAEgxI
    // this programs is the same as detecting cycle in directed graph
    /*
    approach
    for this problem we take an 'edge list' and begin to do bfs on every one of its neighbors.
    we have 3 different states. the unvisited '0', the in process of being visited '1' and the 
    visited '2'.
    if when we are exploring the posibilities of a node and we come back again to an edge that
    is in process of being visited (node in state 1) then that means that we have found a back edge.
    this means a cycle on the edge list.
    on the other hand if we are exploring and find a node in the 2 state thats ok. because its 
    already being completely visited before.

    0  -> 1
    | ^
    |  \
    V    \
    2 -> 3
    This was my best take at making the adjacency list [[0,1], [0,2], [2,3], [3,0]]

    very important
    an adjacency list would look like this 
    0 -> 1, 2
    1 -> null
    2 -> 3
    3 -> 0



    */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // step 1. create adjacency list
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        for(int i = 0; i < numCourses;i++ ){
            adj[i]= new ArrayList();
        }
        
        for(int[] pre : prerequisites){
            adj[pre[0]].add(pre[1]);
        }
        // step 2. keep an array of visited
        // state unvisited == 0
        // state being visited == 1
        // state completely visited == 2
        int[] visited = new int[numCourses];

        // step 3. start a dfs. from a node visit all the nodes that are reachable from there
        for(int i = 0; i< numCourses; i++){
            if(visited[i] == 0 && !isAcyclicGraphDFS(adj, visited, i)){
                return false;
            }
        }
        return true;
    }
    
    // return false if this finds a cycle.
    private boolean isAcyclicGraphDFS(ArrayList<Integer>[] adj, int[] visited, int v){
        // if the currently being visited is on being visited during this run then we have a back edge (one that could cycle us)
        if(visited[v] == 1) return false;
        visited[v] = 1;
        for(int ad: adj[v]){
            if(!isAcyclicGraphDFS(adj,visited,ad)) return false;
        }
        visited[v] = 2;
        return true;
    }
}