/*
Given two strings s and t, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".

Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Example 2:

Input: s = "a", t = "a"
Output: "a"
 

Constraints:

1 <= s.length, t.length <= 105
s and t consist of English letters.
 

Follow up: Could you find an algorithm that runs in O(n) time?
https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/902/
*/
/*
approach
two pointers sliding window. 
keep two pointer and once we have found a substring slide the left pointer 
until we cant have a substring containing all of t. to keep track of this 
size use another integer. 
*/

class Solution {
        public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int minl = 0;
        int minr = s.length();
        
        for(int l = 0, r = 0, count = 0; r < s.length(); r++){
            char c = s.charAt(r);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) >= 0) count++;
            }
            
            while(count == t.length()){
                if(r - l < minr){
                    minl = l;
                    minr = r - l;
                }
                char cl = s.charAt(l);
                if(map.containsKey(cl)){
                    map.put(cl, map.get(cl) + 1);
                    if(map.get(cl) > 0) count--;
                }
                l++;
            }
        }
        
        if(minr == s.length()) return "";        
        
        return s.substring(minl, minl + minr + 1);
    }
}