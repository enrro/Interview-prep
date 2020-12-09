/*Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 

Constraints:

s consists only of printable ASCII characters.
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3411/
*/

class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int l = 0;
        int r = n-1;
        
        while(l < r){
            while(l < n  && !Character.isLetterOrDigit(s.charAt(l)))l++;
            while(r >= 0 && !Character.isLetterOrDigit(s.charAt(r)))r--;
            if(l > n || r < 0 || l > r)break;
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) return false;
            
            l++;
            r--;
        }
        return true;
    }
}