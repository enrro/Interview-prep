/*
Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
 

Example 1:

Input: s = "abcde", words = ["a","bb","acd","ace"]
Output: 3
Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
Example 2:

Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
Output: 2
 

Constraints:

1 <= s.length <= 5 * 104
1 <= words.length <= 5000
1 <= words[i].length <= 50
s and words[i] consist of only lowercase English letters.
https://leetcode.com/problems/number-of-matching-subsequences/
*/
class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        HashMap<Character, Queue<String>> map = new HashMap<>();
        
        for(char c = 'a'; c <= 'z'; c++){
            map.put(c, new LinkedList<String>());
        }
        for(String word: words){
            map.get(word.charAt(0)).add(word);
        }
        
        int count = 0;
        for(char c: S.toCharArray()){
            Queue<String> queue = map.get(c);
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String word = queue.poll();
                if(word.length() == 1){
                    count++;
                }else{
                    map.get(word.charAt(1)).offer(word.substring(1));
                }
            }
        }
        return count;
    }
}