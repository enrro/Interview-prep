/*
Sort Characters By Frequency
------------------------------
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
*/

class Solution {
    // map the characters, 
    // store the ordered characters 
    // add characters to result
    public String frequencySort(String s) {
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        for(char c:s.toCharArray()){
            hm.put(c,hm.getOrDefault(c,0)+1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> hm.get(b) - hm.get(a));
        maxHeap.addAll(hm.keySet());
        
        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()){
            char c = maxHeap.remove();
            
            for(int i = 0; i < hm.get(c);i++){
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}