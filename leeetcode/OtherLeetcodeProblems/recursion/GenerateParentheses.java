/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8
https://leetcode.com/explore/interview/card/amazon/84/recursion/2988/
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList();
        backtrack(output, "", 0, 0, n);
        return output;
    }
    

    public void backtrack(List<String> list, String str, int open, int close, int max){
        if(str.length() == max * 2){
            list.add(str);
            return;
        }
        if(open < max)
            backtrack(list, str + "(", open + 1, close, max);
        if(close < open)
            backtrack(list, str + ")", open, close + 1, max);
    }
}