/**
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 

Example 1:


Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Example 2:

Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit or '.'.
https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/769/
 */

class Solution {
    public boolean isValidSudoku(char[][] board) {
        return validateSquare(board) && validateRow(board) && validateCol(board);
    }
    
    public boolean validateRow(char[][] board){
        for(int i = 0; i < board.length; i++){
            int[] row = new int[9];
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == '.') continue;
                int cel = board[i][j] - '0';
                if(row[cel - 1] != 0) return false;
                else row[cel - 1] = cel;
            }
        }
        return true;
    }
    
    public boolean validateCol(char[][] board){
        for(int i = 0; i < board.length; i++){
            int[] col = new int[9];
            for(int j = 0; j < board[i].length; j++){
                if(board[j][i] == '.') continue;
                int cel = board[j][i] - '0';
                if(col[cel - 1] != 0) return false;
                else col[cel - 1] = cel;
            }
        }
        return true;
    }
    
    public boolean validateSquare(char[][] board){
        for(int offset =  0; offset < 9; offset += 3){
            for(int coffset =  0; coffset < 9; coffset += 3){
                HashSet<Integer> hs = new HashSet();
                for(int i = 0 + offset; i < offset + 3; i++){
                    for(int j = 0 + coffset; j < coffset + 3; j++){
                        if(board[j][i] == '.') continue;
                        int cel = board[j][i] - '0';
                        // System.out.println("i: " + i + "j: " + j + " cel: " + cel + " board[j][i] " + board[j][i]);
                        if(!hs.add(cel)) return false;
                    }
                }
            }
        }
        return true;
    }
}


// better version
/*
Collect the set of things we see, encoded as strings. For example:

'4' in row 7 is encoded as "(4)7".
'4' in column 7 is encoded as "7(4)".
'4' in the top-right block is encoded as "0(4)2".
Scream false if we ever fail to add something because it was already added (i.e., seen before).
*/
public boolean isValidSudoku(char[][] board) {
    Set seen = new HashSet();
    for (int i=0; i<9; ++i) {
        for (int j=0; j<9; ++j) {
            char number = board[i][j];
            if (number != '.')
                if (!seen.add(number + " in row " + i) ||
                    !seen.add(number + " in column " + j) ||
                    !seen.add(number + " in block " + i/3 + "-" + j/3))
                    return false;
        }
    }
    return true;
}