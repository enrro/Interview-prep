/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        int[] charCount = new int[26];
        
        for(char c : p.toCharArray()){
            charCount[c - 'a']++;
        }
        
        int left = 0;
        int right = 0;
        int count = p.length();
        // s: "cbaebabacd" p: "abc"
        while(right < s.length()){
            if(charCount[s.charAt(right++) - 'a']-- >= 1) count--;
            if(count == 0) result.add(left);
            
            // if you have expanded the window to the size of the string to 
            // 1. move the left part 
            // 2. recover the character that you substracted.
            if(right - left == p.length() && charCount[s.charAt(left++) - 'a']++ >= 0)count++;
        }
        return result;
    }
}

/*
slightly more verbose. highly more readable
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] letters = new int[26]; 
        int n = p.length();
        List<Integer> out = new ArrayList<>();
        for(char c : p.toCharArray()){
            letters[c - 'a']++;
        }
        
        int left = 0;
        int right = 0;
        int count = p.length();
        // s: "cbaebabacd" p: "abc"
        while(right < s.length()){
            if(letters[s.charAt(right) - 'a'] >= 1) count--;
            letters[s.charAt(right) - 'a']--;
            right++;
            if(count == 0) out.add(left);
            
            // if you have expanded the window to the size of the string to 
            // 1. move the left part 
            // 2. recover the character that you substracted.
            if(right - left == p.length()){
                if(letters[s.charAt(left) - 'a'] >= 0){
                    count++;
                }
                letters[s.charAt(left) - 'a']++;
                left++;
            }
            
        }
        return out;
    }
}