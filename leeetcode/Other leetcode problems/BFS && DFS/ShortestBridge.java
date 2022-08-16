/**
You are given an n x n binary matrix grid where 1 represents land and 0 represents water.

An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.

You may change 0's to 1's to connect the two islands to form one island.

Return the smallest number of 0's you must flip to connect the two islands.

 

Example 1:

Input: grid = [[0,1],[1,0]]
Output: 1
Example 2:

Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
Output: 2
Example 3:

Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1
 

Constraints:

n == grid.length == grid[i].length
2 <= n <= 100
grid[i][j] is either 0 or 1.
There are exactly two islands in grid.

https://leetcode.com/problems/shortest-bridge/
 */

 class Solution {
    public int shortestBridge(int[][] grid) {
        boolean flag = false;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if (grid[i][j] == 1) {
                    bfs(grid, i, j, q);
                    flag=true;
                    break;
                    
                }
            }
            if(flag) break;
        }
        int count = 0;
        
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] point = q.poll();
                for(int[] d : dir){
                    int x = d[0] + point[0];
                    int y = d[1] + point[1];
                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] != -1){
                        if(grid[x][y] == 1) return count;
                        q.offer(new int[]{x,y});
                        grid[x][y] = - 1;
                    }
                }
            }
            count++;
        }
        
        return -1;
    }
    
    public void bfs(int[][] grid, int x, int y, Queue<int[]> q){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[x].length || grid[x][y] != 1) return;
        
        q.offer(new int[]{x,y});
        grid[x][y] = - 1;
        
        bfs(grid, x + 1, y, q);
        bfs(grid, x - 1, y, q);
        bfs(grid, x, y + 1, q);
        bfs(grid, x, y - 1, q);
    }
}