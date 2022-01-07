/**
Given a string s, return true if the s can be palindrome after deleting at most one character from it.

 

Example 1:

Input: s = "aba"
Output: true
Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
Example 3:

Input: s = "abc"
Output: false
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/289/
 */


 class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        
        while(l < r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            } else {
                return isPalindrom(s, l + 1, r) || isPalindrom(s, l, r - 1);
            }
        }
        return true;
        
    }
    
    public boolean isPalindrom(String s, int l, int r){
        while(l <= r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}