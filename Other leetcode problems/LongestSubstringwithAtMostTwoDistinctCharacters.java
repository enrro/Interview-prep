/*Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
Example 2:

Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.*/

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap();
        int max = 0;
        int slow = 0;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(s.charAt(i), 1+map.getOrDefault(s.charAt(i),0));
            
            while(map.size() > 2){
                map.put(s.charAt(slow), map.getOrDefault(s.charAt(slow),0)-1);
                if(map.get(s.charAt(slow)) == 0) map.remove(s.charAt(slow));
                slow++;
            }
            max = Math.max(max, i-slow+1);
        }
        
        return max;
    }
}