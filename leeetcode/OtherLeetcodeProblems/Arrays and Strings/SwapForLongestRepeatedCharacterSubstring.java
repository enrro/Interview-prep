/*
Given a string text, we are allowed to swap two of the characters in the string. Find the length of the longest substring with repeated characters.

 

Example 1:

Input: text = "ababa"
Output: 3
Explanation: We can swap the first 'b' with the last 'a', or the last 'b' with the first 'a'. Then, the longest repeated character substring is "aaa", which its length is 3.
Example 2:

Input: text = "aaabaaa"
Output: 6
Explanation: Swap 'b' with the last 'a' (or the first 'a'), and we get longest repeated character substring "aaaaaa", which its length is 6.
Example 3:

Input: text = "aaabbaaa"
Output: 4
Example 4:

Input: text = "aaaaa"
Output: 5
Explanation: No need to swap, longest repeated character substring is "aaaaa", length is 5.
Example 5:

Input: text = "abcdef"
Output: 1
https://leetcode.com/problems/swap-for-longest-repeated-character-substring/
*/

class Solution {
    public int maxRepOpt1(String text) {
                int firstPointer = 0;
        int secondPointer = 0;
        int n = text.length();
        int maxVal = Integer.MIN_VALUE;
        
        Map<Character, Integer> map = new HashMap<>();
        
        //get the count of all characters
        for(int i=0;i<text.length();i++){
            char letter = text.charAt(i);
            map.put(letter, map.getOrDefault(letter, 0) + 1);    
        }
        
        while(firstPointer < n){
           
            char letter = text.charAt(secondPointer);
            int lastUnique = firstPointer;
            
            //iterate till we have a continuous block.
            int countSoFar = 0;
            while(secondPointer < n && text.charAt(secondPointer) == letter){
                secondPointer++;
                countSoFar++;
            }
            
            //at this point we have a new character found
            lastUnique = secondPointer;
            
            //if we can replace the new character with the letter we were iterating, we need them to be present in the string. ex : ababa. here, to replace first b at position 1, we needed count of a to be more than what we have seen so far. otherwise every replaceable a is already seen. say in this example. aaab. we have already seen 3 a. we cant replace b with any other a in the string.
            
            if(map.get(letter) - countSoFar > 0){
                secondPointer++;
            }
            
            //now again iterate till we have different character
            while(secondPointer < n && text.charAt(secondPointer) == letter){
                secondPointer++;
            }
            
            //this res is because : aaabaa. Now we replace b with a later than b. we have 2 more. But that is already included in the count. max we can make here is 5 and not 6. 
            int res = Math.min(secondPointer-firstPointer, map.get(letter));
            
            maxVal = Math.max(res, maxVal);
            //now start with last different character and continue the loop same way for next unique letter
            firstPointer = secondPointer = lastUnique;
        }
     
        return maxVal;
    }
}