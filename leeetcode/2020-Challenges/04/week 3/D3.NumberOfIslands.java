/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
*/

/**
Approach
cound if land is found and then sink every piece of land in an island 
 */
class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0; 
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    mark(grid,i,j);
                    islands++;
                }
            }
        }
        
        return islands;
    }
    
    public void mark(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i > grid.length - 1 || j > grid[i].length -1 || grid[i][j] == '0') return;
        grid[i][j] = '0';
        
        mark(grid,i + 1,j);
        mark(grid,i - 1,j);
        mark(grid,i,j + 1);
        mark(grid,i,j - 1);
    }
}


class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length ==  0 || grid  == null) return 0;
        boolean[][] found = new boolean[grid.length][grid[0].length];
        int noislands = 0;
        for(int  i = 0; i<grid.length;i++){
            for(int j = 0; j < grid[i].length;j++){
                if(grid[i][j] == '1' && !found[i][j]){
                    noislands += foundEarth(grid, found, i, j);
                }
            }
        }
        printArray(found);
        
        return noislands; 
    }
    
    public int foundEarth(char[][] grid, boolean[][] found, int row, int col){
        if(row > grid.length - 1 ||
           row < 0 ||
           col > grid[row].length -1 ||
           col < 0 ||
           grid[row][col] == '0'  || 
           found[row][col] == true){
            return 0;
        }
        found[row][col] = true;
        foundEarth(grid, found, row+1, col);
        foundEarth(grid, found, row-1, col);

        foundEarth(grid, found, row, col+1);
        foundEarth(grid, found, row, col-1);

        return 1;
    }
    
    public void printArray(boolean[][] array){
        for (boolean[] arr : array){
            System.out.println(Arrays.toString(arr));
        }
    }
}

