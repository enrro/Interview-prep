/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

// aproach. slide the window until you find a repeated character and then contract left side
// until you no longer have a repeating character
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // sliding window
        if(s ==null) return 0;
        int front = 0, back = 0, max = 0;
        HashSet<Character> hs = new HashSet<>();
        
        while(front < s.length()){
            if(hs.contains(s.charAt(front))){
                hs.remove(s.charAt(back));
                back++;
            }else{
                hs.add(s.charAt(front));
                front++;
                max = Math.max(hs.size(), max);
                
            }
            System.out.println(hs);
        }
        return max;
    }
}

// another approach 
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        int max = 0;
        for(int r = 0, l = 0; r < n; r++){
            char c = s.charAt(r);
            if(set.add(c)){
                max = Math.max(max, set.size());
            }else{
                while(!set.add(c)){
                    set.remove(s.charAt(l++));
                }
            }
            
        }
        return max;
    }
}