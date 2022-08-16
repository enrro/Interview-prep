/*
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

 

Example 1:


Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:


Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
 

Constraints:

1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]
https://leetcode.com/problems/number-of-provinces/
*/
/*
deep first search approach
*/

class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        
        for(int i = 0; i < isConnected.length; i++){
            if(!visited[i]){
                dfs(isConnected, visited, i);
                count++;
            }
        }
        
        return count;
    }
    
    public void dfs(int[][] isConnected, boolean[] visited, int city){
        for(int road = 0; road < isConnected[city].length; road++){
            if(isConnected[city][road] == 1 && !visited[road]){
                visited[road] = true;
                dfs(isConnected, visited, road);
            }
        }
    }
}


/*
disjoint set approach
*/
class Solution {
    public int findCircleNum(int[][] M) {
        //corner case
        if (M == null || M.length == 0) return 0;
        
        //initialization: count = n, each id = id
        int m = M.length;
        int count = m;
        int[] roots = new int[m];
        for (int i = 0; i < m; i++) roots[i] = i; 
        
        //for loop and union find
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                //if there is an edge, do union find
                if (M[i][j] == 1) {
                    int root0 = find (roots, i);
                    int root1 = find (roots, j);
                    
                    if (root0 != root1) {
                        roots[root1] = root0;
                        count--;
                    }
                }
            }
        }
        
        //return count
        return count;
    }
    
    public int find (int[] roots, int id) {
        while (id != roots[id]) {
            id = roots[roots[id]];
        }
        return id;
    }
}