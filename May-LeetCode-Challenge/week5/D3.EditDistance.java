/*
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
*/

class Solution {
    public int minDistance(String word1, String word2) {
        // create a matrix of integer ecuals to the lenght of the string + 1 for the base case of "" empty string
        int[][] matrix = new int[word2.length()+1][word1.length()+1];
        
        // adding the base case for empty string
        for(int row=0;row < word2.length()+1;row++){
            matrix[row][0] = row;
        }
        
        for(int col = 0; col < word1.length()+1;col++){
            matrix[0][col] = col;
        }
        
        // print2D(matrix);
        // System.out.print("\n");
        for(int row = 1; row < word2.length()+1;row++){
            for(int col = 1; col < word1.length()+1;col++){
                if(word1.charAt(col-1) == word2.charAt(row-1)){
                    //if the characters are the same it means that no change needs to be made
                    matrix[row][col] = matrix[row-1][col-1];
                }else{
                    // otherwise we should find the min value between the
                    // value right above current
                    // value to the left of current
                    // diagonal value of current
                    matrix[row][col] = Math.min(Math.min(matrix[row-1][col],matrix[row][col-1]),
                                            matrix[row-1][col-1]) + 1;
                }
            }
        }
        // print2D(matrix);
        return matrix[word2.length()][word1.length()];
    }
    
    public static void print2D(int mat[][]) 
    { 
        // Loop through all rows 
        for (int i = 0; i < mat.length; i++){ 
  
            // Loop through all elements of current row 
            for (int j = 0; j < mat[i].length; j++){ 
                System.out.print(mat[i][j] + " ");
            }
            System.out.print("\n");
        }
    } 
}