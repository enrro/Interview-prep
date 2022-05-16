/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
Example 2:


Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
Example 3:

Input: matrix = [[1]]
Output: [[1]]
Example 4:

Input: matrix = [[1,2],[3,4]]
Output: [[3,1],[4,2]]
 

Constraints:

matrix.length == n
matrix[i].length == n
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000
https://leetcode.com/explore/interview/card/google/59/array-and-strings/3052/
*/

class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        int n = matrix.length;
        int x = 0;
        int y = 0;
        
        while(n  > 1){
            // System.out.println(n);
            while(x + y < n - 1){
                int temp = matrix[y][y+x];
                // System.out.println("temp: " + temp + " matrix[y+x][n-1]: " + matrix[y+x][n-1]);
                temp ^= matrix[y+x][n-1];
                matrix[y+x][n-1] ^= temp;
                temp ^= matrix[y+x][n-1];
                // System.out.println(temp);
                // System.out.println(matrix[0][n-1]);

                // System.out.println("temp: " + temp + " matrix[n-1-y][n-1-x-y]: " + matrix[n-1][n-1-x]);
                temp ^= matrix[n-1][n-1-x];
                matrix[n-1][n-1-x] ^= temp;
                temp ^= matrix[n-1][n-1-x];

                // System.out.println("temp: " + temp + " matrix[n-1-x][y]: " + matrix[n-1-x][y]);
                temp ^= matrix[n-1-x][y];
                matrix[n-1-x][y] ^= temp;
                temp ^= matrix[n-1-x][y];

                matrix[y][y+x] = temp;
                // temp ^= matrix[0][0];
                x++;
            }
            y++;
            n--;
            x = 0;
        
        }
        // for(int[] arr : matrix){
        //     System.out.println(Arrays.toString(arr));
        // }
    }
    
}

// solution 2 BEST
// The idea was firstly transpose the matrix and then flip it symmetrically. For instance,

// 1  2  3             
// 4  5  6
// 7  8  9
// after transpose, it will be swap(matrix[i][j], matrix[j][i])

// 1  4  7
// 2  5  8
// 3  6  9
// Then flip the matrix horizontally. (swap(matrix[i][j], matrix[i][matrix.length-1-j])

// 7  4  1
// 8  5  2
// 9  6  3
public class Solution {
    public void rotate(int[][] matrix) {
        // transpose the matrix 
        for(int i = 0; i<matrix.length; i++){
            for(int j = i; j<matrix[0].length; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // flip it symmetrically.
        for(int i =0 ; i<matrix.length; i++){
            for(int j = 0; j<matrix.length/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }
}