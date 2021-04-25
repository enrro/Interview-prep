/*
Given a character array s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by a single space.

 

Example 1:

Input: s = ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
Example 2:

Input: s = ["a"]
Output: ["a"]
 

Constraints:

1 <= s.length <= 105
s[i] is an English letter (uppercase or lowercase), digit, or space ' '.
There is at least one word in s.
s does not contain leading or trailing spaces.
All the words in s are guaranteed to be separated by a single space.
 

Follow up: Could you do it in-place without allocating extra space?
https://leetcode.com/explore/interview/card/microsoft/30/array-and-strings/213/
*/
class Solution {
    public void reverseWords(char[] s) {
        int n = s.length;
        reverse(s, 0, n - 1);
        
        for(int fast = 0, slow = 0; fast <= n; fast++){
            if(fast == n || s[fast] == ' '){
                reverse(s, slow, fast-1);
                slow = fast+1;
            }
        }
    }
    
    public void reverse(char[] s, int l, int r){
        while(l < r){
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}