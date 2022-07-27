/*
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.

Example 1:
11000
11000
00011
00011
Given the above grid map, return 1.
Example 2:
11011
10000
00001
11011
Given the above grid map, return 3.

Notice that:
11
1
and
 1
11
are considered different island shapes, because we do not consider reflection / rotation.
Note: The length of each dimension in the given grid does not exceed 50.
*/
class Solution {
    public int numDistinctIslands(int[][] grid) {
        HashSet<String> hs = new HashSet();
        
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[i].length;j++){
                if(grid[i][j] != 0){
                    StringBuilder sb = new StringBuilder();
                    bfs(grid, sb, "o", i, j);
                    hs.add(sb.toString());
                }
            }
        }
        
        return hs.size();
    }
    
    public void bfs(int[][] grid, StringBuilder sb, String dir, int row, int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == 0){
            return;
        }
        sb.append(dir);
        grid[row][col] = 0;
        bfs(grid, sb, "u", row+1, col);
        bfs(grid, sb, "d", row-1, col);
        bfs(grid, sb, "r", row, col+1);
        bfs(grid, sb, "l", row, col-1);
        sb.append("b");
    }
}
        // last sb.append("b");  is necesary to completely diferentiate between islands with similar patterns without backtracking.
/**
for example
[[1,1,0],
[0,1,1],
[0,0,0],
[1,1,1],
[0,1,0]]
 */