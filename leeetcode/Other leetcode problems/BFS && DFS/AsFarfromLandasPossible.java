/*
Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized, and return the distance. If no land or water exists in the grid, return -1.

The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.

 

Example 1:


Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
Output: 2
Explanation: The cell (1, 1) is as far as possible from all the land with distance 2.
Example 2:


Input: grid = [[1,0,0],[0,0,0],[0,0,0]]
Output: 4
Explanation: The cell (2, 2) is as far as possible from all the land with distance 4.
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1
https://leetcode.com/problems/as-far-from-land-as-possible/
*/
/*
approach
DFS Solution
For each 'land' cell, start DFS and record the distance in 'water' cells.

If the distance in the 'water' cell is smaller than the current distance, we stop there. Otherwise, we update the distance to the smaller value and keep going.

So our grid will have the following values:

1 for land
0 for water
>=2 water with the recorded distance
In the end, we scan the grid again and returning the largest value.

In this example, the cells contains distances after DFS is complete for each land cell. In the end, the maximum distance from the land is 3 (4 - 1).
1 0 0 0
0 0 0 0
0 0 1 0
0 0 0 0
0 0 0 0
0 1 0 0

1 2 3 4
2 3 4 5
3 4 1 6
4 5 6 7
5 6 7 8
6 1 8 9

1 2 3 4
2 3 2 3
3 2 1 2 
4 3 2 3 
5 4 3 4
6 1 4 5

1 2 3 4
2 3 2 3 
3 2 1 2 
4 3 2 3 
2 2 3 4 
2 1 2 2


*/
class Solution {
    public int maxDistance(int[][] grid) {
        int max = -1;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length;j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    manhattan(grid, i, j, 1);
                }
            }
        }
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length;j++){
                if((grid[i][j] > 1)){
                    max = Math.max(max, grid[i][j]  - 1);
                }
            }
        }
        
        return max;
    }
    
    public void manhattan(int[][] grid, int x, int y, int distance){
        if(x < 0
          || y < 0
          || x >= grid.length
          || y >= grid[x].length
          || grid[x][y] != 0 && grid[x][y] <= distance){
            return;
        }
        grid[x][y] = distance;
        
        manhattan(grid, x + 1, y, distance + 1);
        manhattan(grid, x - 1, y, distance + 1);
        manhattan(grid, x, y + 1, distance + 1);
        manhattan(grid, x, y - 1, distance + 1);
        
    }
}