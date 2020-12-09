/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.*/


class Solution {
    public int firstUniqChar(String s) {
        char[] arr = new char[26];
        
        for(int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            arr[c-'a'] += 1;
        }
        
        for(int  i = 0; i < s.length();i++){
            char c = s.charAt(i);
            if(arr[c-'a'] == 1){
                return i;
            }
        }
        
        return -1;
    }
}