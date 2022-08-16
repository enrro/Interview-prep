/*
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

 

Example 1:


Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.
https://leetcode.com/problems/01-matrix/
*/

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        int n = mat.length, m = mat[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            for(int[] dir : directions){
                int row = dir[0] + curr[0];
                int col = dir[1] + curr[1];
                
                if(row < 0 || col < 0 || row >= n || col >= m || visited[row][col]){
                    continue;
                }
                mat[row][col] = mat[curr[0]][curr[1]] + 1;
                visited[row][col] = true;
                queue.offer(new int[]{row, col});
            }
        }
        
        return mat;
    }
}