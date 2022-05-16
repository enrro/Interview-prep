/*Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters (lower-case and/or upper-case),
https://leetcode.com/explore/interview/card/amazon/80/dynamic-programming/489/
*/

class Solution {
    public String longestPalindrome(String s) {
        int left = 0, right = 0;
        
        for(int i = 0; i < s.length(); i++){
            int odd = maxPal(s, i, i);
            int even = maxPal(s, i, i + 1);
            int max = Math.max(odd, even);
            
            if(max > right - left){
                // -1 to account for even values
                // if there where only odds -1 would be not needed
                left = i - (max - 1) / 2;
                right = i + max / 2;
            }
            
        }
        
        return s.substring(left, right+1);
    }
    
    public int maxPal(String s, int l, int r){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        // notice we substract 1. because of the base cases.
        // if we do odd. then we end up with a 2 (r - l) == (1 - -1) thus we need to substract 1
        // if we do even. 1 - 0 = 1. we need again to substract 1. 
        return r - l - 1;
    }
}