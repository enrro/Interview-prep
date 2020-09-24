/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 

Constraints:

board and word consists only of lowercase and uppercase English letters.
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3

* * deep first search exaple
*/
class Solution {
    public boolean exist(char[][] board, String word) {
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                if(recursiveExist(board, word, r, c, 0)) return true;
            }
        }
        return false;
    }
    
    
    public boolean recursiveExist(char[][] board, String word, int r, int c, int i) {
        if(i == word.length()) return true;
        if(r < 0
          || c < 0
          || r == board.length
          || c == board[r].length
          || board[r][c] == ' ')
            return false;
        
        if(board[r][c] != word.charAt(i)) return false;
        char buf = board[r][c];
        board[r][c] = ' ';
        boolean res =  recursiveExist(board, word, r + 1, c, i+1)
                    || recursiveExist(board, word, r - 1, c, i+1)
                    || recursiveExist(board, word, r, c + 1, i+1)
                    || recursiveExist(board, word, r, c - 1, i+1);
        board[r][c] = buf;
        
        
        return res;
    }
}