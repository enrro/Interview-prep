/*
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

 

Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.
 

Constraints:

1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.

https://leetcode.com/problems/longest-palindrome/
*/

class Solution {
    public int longestPalindrome(String s) {
        int[] abc = new int[128];
        int pair = 0;
        int unpair = 0;
        int countUnpair = 0;
        for(char c : s.toCharArray()){
            abc[c]++;
        }
        
        

        for(int i = 0; i < abc.length; i++){
            if(abc[i] > 0){
                if(abc[i] % 2 == 0){
                    pair += abc[i];
                }else{
                    countUnpair += 1;
                    unpair += abc[i] - 1;
                }
            }
        }
        
        return pair + unpair + (countUnpair > 0? 1 : 0);
    }
    
}