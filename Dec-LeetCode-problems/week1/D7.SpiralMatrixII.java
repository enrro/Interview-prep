/*
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

 

Example 1:


Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
Example 2:

Input: n = 1
Output: [[1]]
 

Constraints:

1 <= n <= 20
https://leetcode.com/explore/featured/card/december-leetcoding-challenge/569/week-1-december-1st-december-7th/3557/
*/

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int counter = 1;
        
        int startRow = 0;
        int endRow = n-1;
        int startCol = 0;
        int endCol = n-1;
        
        while(startRow <= endRow && startCol <= endCol){
            for(int col = startCol; col <= endRow; col++){
                matrix[startRow][col] = counter++;
            }
            startRow++;

            for(int row = startRow; row <= endRow; row++){
                matrix[row][endCol] = counter++;
            }
            endCol--;

            for(int col = endCol; col >= startCol; col--){
                matrix[endRow][col] = counter++;
            }
            endRow--;
            for(int row = endRow; row >= startRow; row--){
                matrix[row][startCol] = counter++;
            }
            startCol++;            
        }


        return matrix;
    }
}