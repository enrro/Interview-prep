/*
You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

 

Example 1:


Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
Example 2:


Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
Explanation: All 1s are either on the boundary or can reach the boundary.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 500
grid[i][j] is either 0 or 1.
https://leetcode.com/problems/number-of-enclaves/
*/

class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++){
            if(grid[i][0] == 1) sink(grid, i, 0);
            if(grid[i][m - 1] == 1) sink(grid, i, m - 1);
        }
        for(int i = 0; i < m; i++){
            if(grid[0][i] == 1) sink(grid, 0, i);
            if(grid[n - 1][i] == 1) sink(grid, n - 1, i);
        }
        
        int sum = 0;
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(grid[i][j] == 1){
                    sum += sink(grid, i, j);
                }
            }
        }
        
        return sum;
    }
    
    
    public int sink(int[][] grid, int x, int y){
        if(x < 0
          || y < 0
          || x >= grid.length
          || y >= grid[x].length
          || grid[x][y] == 0) return 0;
        
        grid[x][y] = 0;
        
        return  sink(grid, x, y + 1) + 
                sink(grid, x, y - 1) + 
                sink(grid, x + 1, y) + 
                sink(grid, x - 1, y) + 1;
    }
}