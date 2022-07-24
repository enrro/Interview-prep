/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
 

Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.
https://leetcode.com/problems/isomorphic-strings/
*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] arr = new int[512];
         // since 0 is the default of the empty arr.
         // we use -1 to keep 0 as a valid index in the array.
        Arrays.fill(arr, -1);
        
        for(int i = 0; i < s.length(); i++){
            if(arr[s.charAt(i)] != arr[t.charAt(i) + 256]) return false;
            
            arr[s.charAt(i)] = i;
            arr[t.charAt(i) + 256] = i;
        }
        
        return true;
    }
}