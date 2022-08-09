/*
Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.

 

Example 1:



Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
Output: 2
Explanation: 
Islands in gray are closed because they are completely surrounded by water (group of 1s).
Example 2:



Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
Output: 1
Example 3:

Input: grid = [[1,1,1,1,1,1,1],
               [1,0,0,0,0,0,1],
               [1,0,1,1,1,0,1],
               [1,0,1,0,1,0,1],
               [1,0,1,1,1,0,1],
               [1,0,0,0,0,0,1],
               [1,1,1,1,1,1,1]]
Output: 2
 

Constraints:

1 <= grid.length, grid[0].length <= 100
0 <= grid[i][j] <=1

https://leetcode.com/problems/number-of-closed-islands/
*/
/*
Approach 1: Flood Fill
First, we need to remove all land connected to the edges using flood fill.

Then, we can count and flood-fill the remaining islands.

*/

class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int sum = 0;
        
        for(int row = 0; row < n; row++){
            if (grid[row][0] == 0){
                floodIsland(grid, row, 0);
            }
            if(grid[row][m - 1] == 0){
                floodIsland(grid, row, m - 1);
            }
        }
        
        for(int col = 0; col < m; col++){
            if(grid[0][col] == 0){
                floodIsland(grid, 0, col);
            }
            if(grid[n - 1][col] == 0){
                floodIsland(grid, n - 1, col);
            }
        }
        

        
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(grid[i][j] == 0){
                    floodfill(grid, i, j);
                    sum++;
                }
            }
        }
        
        return sum;
    }
    
    public void floodfill(int[][] grid, int i, int j){
        if(i <  0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 1) return;
        
        grid[i][j] = 1;
        floodfill(grid, i + 1, j);
        floodfill(grid, i - 1, j);
        floodfill(grid, i,j  + 1);
        floodfill(grid, i, j - 1);
    }
}