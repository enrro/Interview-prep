/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.

If the last word does not exist, return 0.

Note: A word is defined as a maximal substring consisting of non-space characters only.

Example:

Input: "Hello World"
Output: 5
https://leetcode.com/explore/featured/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3461/
*/

class Solution {
    public int lengthOfLastWord(String s) {
        int tail = s.length()-1;
        int length = 0;
        while(tail >= 0 && s.charAt(tail) == ' ') tail--;
        while(tail >= 0 && s.charAt(tail) != ' ') {
            length++;
            tail--;
        }
        
        return length;
    }
}

// this solution is too noisy
class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int ans = 0;
        while(n > 0){
            if(s.charAt(--n) != ' ') ans++;
            else if(ans != 0) return ans++;
        }
        
        return ans;
    }
}