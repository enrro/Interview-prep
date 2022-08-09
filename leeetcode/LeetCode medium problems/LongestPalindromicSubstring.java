/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
*/

class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1) return "";
        
        int start = 0;
        int end = 0;
        
        for(int i = 0; i < s.length(); i++){
            int odd =  longestFromMiddle(s,i,i); // //assume odd length, try to extend Palindrome as possible. example " aba"
            int even = longestFromMiddle(s,i,i+1); //assume even length. example "abba"
            int maxlen = Math.max(odd, even);
            
            if(maxlen > (end - start)){
                start = i - ((maxlen - 1) / 2); // minus 1 to account for oneself. think of base case 1 for word "a" and first even case "bb"
                end = i + ((maxlen) / 2);
            }   
        }
        
        return s.substring(start, end + 1); // substring dosn't add the end so we need to add + 1 to add to the result
    }
    
    public int longestFromMiddle(String s, int left, int right){
        if(s == null || left > right){return 0;}
        
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        
        return right - left - 1; 
    }
}