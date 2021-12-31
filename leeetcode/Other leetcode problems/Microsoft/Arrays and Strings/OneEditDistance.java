/*
Given two strings s and t, return true if they are both one edit distance apart, otherwise return false.

A string s is said to be one distance apart from a string t if you can:

Insert exactly one character into s to get t.
Delete exactly one character from s to get t.
Replace exactly one character of s with a different character to get t.
 

Example 1:

Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.
Example 2:

Input: s = "", t = ""
Output: false
Explanation: We cannot get t from s by only one step.
 

Constraints:

0 <= s.length, t.length <= 104
s and t consist of lowercase letters, uppercase letters, and digits.
https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3015/
*/

class Solution {
    // we have to handle the case in which they have the same distance
    // and were s is shorter than t by 1 char.
    public boolean isOneEditDistance(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        // make s always shorter than t
        if (n2 < n1) {
            return isOneEditDistance(t, s);
        }
        
        // taking care of same distance 
        boolean sameDist = (n1 == n2);
        for (int i = 0; i < n1; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (sameDist) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        
        // taking care of shorter by one char
        return (n1 + 1 == n2) || (n2 + 1 == n1);
    }
}