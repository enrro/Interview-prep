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


/*https://www.youtube.com/watch?v=b6AGUjqIPsA this video is a good reference */
class Solution {
    public int minDistance(String word1, String word2) {
        // create a matrix of integer ecuals to the lenght of the string + 1 for the base case of "" empty string
        // this matrix represents the characters in both words. the rows are the chars at word1 and cols at word 2
        int n = word1.length(), m = word2.length();
        int[][] matrix = new int[m+1][n+1];
        
        // populate empty string cases for "row" word
        for(int i = 0; i < n+1; i++){
            matrix[0][i] = i;
        }
        // populate empty string cases for "col" word
        for(int i = 0; i < m+1; i++){
            matrix[i][0] = i;
        }
        // check if both characters are the same. 
        // if they are then we pick the corner side of the matrix, this represents the less efort to make the arrays similar doing nothing
        // if they are not then we pick the minimum value en every other direction and add + 1
        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                if(word1.charAt(j-1) == word2.charAt(i-1)){
                    matrix[i][j] = matrix[i-1][j-1];
                }else{
                    matrix[i][j] = Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j],matrix[i][j-1]))+1;
                }
            }
        }
        // print2D(matrix);
        return matrix[m][n];
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
        System.out.println("");
    } 
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