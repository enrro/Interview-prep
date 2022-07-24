/*
On a 2-dimensional grid, there are 4 types of squares:

1 represents the starting square.  There is exactly one starting square.
2 represents the ending square.  There is exactly one ending square.
0 represents empty squares we can walk over.
-1 represents obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

 

Example 1:

Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
Example 2:

Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
Example 3:

Input: [[0,1],[2,0]]
Output: 0
Explanation: 
There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.
 

Note:
1 <= grid.length * grid[0].length <= 20
https://leetcode.com/problems/unique-paths-iii/
*/

// grad deep first search solution
class Solution {
    public int uniquePathsIII(int[][] grid) {
        int zero = 0, sx = 0, sy = 0;
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 0) zero++;
                else if(grid[r][c] == 1){
                    sx = r;
                    sy = c;
                }
            }
        }
        return dfs(grid, sx, sy, zero);
    }
    
    private int dfs(int[][] grid, int x, int y, int zero){
        if(x< 0 
           || y < 0 
           || x >= grid.length 
           || y >= grid[0].length
           || grid[x][y] == -1)
            return 0;
        if(grid[x][y] == 2)
            return zero == -1 ? 1 : 0;
        grid[x][y] = -1;
        zero--;
        int totalPaths = dfs(grid, x + 1, y, zero) + 
            dfs(grid, x - 1, y, zero) + 
            dfs(grid, x, y + 1, zero) + 
            dfs(grid, x, y - 1, zero);
        
        // when we backtrack we also need to unmark this cell as visited so other paths can
        // navigate this path
        grid[x][y] = 0;
        
        return totalPaths;
    }
}