/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
*/
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0){return 0;}
        int max = 0;
        int[][] nemo = new int[matrix.length][matrix[0].length];
        
        
        
        for(int i = 0; i < nemo.length;i++){
            for(int j = 0; j <nemo[i].length; j++){
                if(i == 0 || j == 0){
                    nemo[i][j] = matrix[i][j] == '1'? 1:0;
                    if(nemo[i][j] == 1 && nemo[i][j] > max) max = nemo[i][j];
                }
                else if(matrix[i][j] != '0'){
                    nemo[i][j] = 1 + Math.min(nemo[i - 1][j], Math.min(nemo[i][j - 1], nemo[i - 1][j - 1]));
                    if(nemo[i][j] > max){
                        max = nemo[i][j];
                    }
                }
            }
            System.out.println(Arrays.toString(nemo[i]));
        }
        return max*max;
    }
}

