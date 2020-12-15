/*
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.
https://leetcode.com/explore/featured/card/december-leetcoding-challenge/570/week-2-december-8th-december-14th/3565/
*/
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList();
        helper(s, new ArrayList(), res);
        
        return res;
    }
    
    public void helper(String s, List<String> curList, List<List<String>> res){
        if(s.isEmpty()){
            res.add(new ArrayList(curList));
        }
        for(int i = 1; i <= s.length(); i++){
            String  left = s.substring(0,i);
            String right = s.substring(i);
            if(isPalindrom(left)){
                curList.add(left);
                helper(right, curList,res);
                curList.remove(curList.size()-1);
            }
            
        }
        
    }
    
    public boolean isPalindrom(String s){
        int l = 0, r = s.length()-1;
        
        while(l <= r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        
        return true;
    }
}