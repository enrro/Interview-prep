/*
Valid Palindrome
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 

Constraints:

s consists only of printable ASCII characters.
*/

class Solution {
    public boolean isPalindrome(String s) {
        
        for(int l = 0, r = s.length()-1; l < r; l++,r--){
            while(l < r && !Character.isLetterOrDigit(s.charAt(l)))l++;
            while(l < r && !Character.isLetterOrDigit(s.charAt(r)))r--;
            //System.out.println(s.charAt(l));
            if(l > r) return false;
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))return false;
            
        }
        
        
        
        return true;
    }
}