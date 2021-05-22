/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

 

Example 1:


Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
Example 3:

Input: m = 7, n = 3
Output: 28
Example 4:

Input: m = 3, n = 3
Output: 6
 

Constraints:

1 <= m, n <= 100
It's guaranteed that the answer will be less than or equal to 2 * 109.
https://leetcode.com/problems/unique-paths/
*/

class Solution {
    /* dp approach. basically we sum the amount of ways we can reach starting possition from end
    position by summing the cell above the current one and the one to the left
    this works by dividing in sub problems first with only a 1 x 1 thn 2 x 2.
    we can see that the top and left most row and col have values are always 1.
    because there is nothing above and to the left of them since they are the edges.
    video explanation here https://www.youtube.com/watch?v=rBAxUTqvlQA
    */
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[n][m];
        
        for(int i = 0; i < n;i++){
            grid[i][0] = 1;
        }
        
        for(int i = 0; i < m;i++){
            grid[0][i] = 1;
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
            }
        }
        
        return grid[n-1][m-1];
    }

}