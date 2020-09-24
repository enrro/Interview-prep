/*Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
Example 2:

Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.*/
// * * this is probably the best sliding window example there is
// use a map to track number of apperences and amount of apperances
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap();
        int max = 0, slow = 0;
        
        for(int i = 0; i < s.length(); i++){
            // add the vale to the map
            char c = s.charAt(i);
            map.put(s.charAt(i), 1+map.getOrDefault(s.charAt(i),0));
            
            // make sure the map the right size
            while(map.size() > 2){
                char t = s.charAt(slow);
                map.put(t, map.get(t)-1);
                if(map.get(t) == 0) map.remove(t);
                slow++;
            }
            
            // get the max
            max = Math.max(max, i - slow + 1);
        }
        
        return max;
    }
}