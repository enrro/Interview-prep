/*
Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.

 

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: The substring is "ece" with length 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: The substring is "aa" with length 2.
 

Constraints:

1 <= s.length <= 5 * 104
0 <= k <= 50
https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3017/
*/


class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int max = 0;
        int count = 0;
        
        for(int l = 0, r = 0; r < n; r++){
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            count++;
            while(map.size() > k){
                char cl = s.charAt(l++);
                map.put(cl, map.get(cl) - 1);
                count--;
                if(map.get(cl) <= 0){
                    map.remove(cl);
                }
            }
            max = Math.max(max, count);
        }
        
        
        return max;
    }
}