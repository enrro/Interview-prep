/*A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

 

Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 

Note:

S will have length in range [1, 500].
S will consist of lowercase English letters ('a' to 'z') only.
https://leetcode.com/explore/featured/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3448/`
*/

/**
Approach.
we need the max distance between the first character and its last ocurrance.
if we find another character along the way, we also need to check for its occurances 
in that case the length of the array grows if the character index is higher than
the current one. we do this process until we reach the end of this section. and then we repeat.
 */
class Solution {
    public List<Integer> partitionLabels(String S) {
        if(S == null || S.length() == 0) return null;
        List<Integer> outputArr = new ArrayList();
        int[] lastIndices = new int[26];
        
        for(int i = 0; i < S.length(); i++){
            lastIndices[S.charAt(i)-'a'] = i;
        }
        
        int start = 0;
        int end = 0;
        
        for(int i= 0; i< S.length();i++){
            end = Math.max(end, lastIndices[S.charAt(i) - 'a']);
            if(i == end){
                outputArr.add(end-start+1);
                start = end + 1;
            }
        }
        
        return outputArr;
        
    }
}