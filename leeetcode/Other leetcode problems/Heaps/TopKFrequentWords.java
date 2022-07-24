/*

Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

 

Example 1:

Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:

Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 

Constraints:

1 <= words.length <= 500
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
k is in the range [1, The number of unique words[i]]
 

Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space?
https://leetcode.com/problems/top-k-frequent-words/
*/

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        List<String> out = new ArrayList();
        
        
        for(String word: words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>((Map.Entry<String,Integer> e1, Map.Entry<String,Integer> e2) -> e1.getValue() == e2.getValue()?
                                                                              e1.getKey().compareTo(e2.getKey()) :  e2.getValue() - e1.getValue());
        
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            pq.offer(entry);
        }
        
        for(int i = k; i > 0; i--){
            out.add(pq.poll().getKey());
        }
        
        return out;
    }
}

/*
another way more readable but very much longer
*/
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word:words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        MyComparator comparator = new MyComparator();
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(comparator);
        // or use this lambda
        // PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) -> e1.getValue()!=e2.getValue()? e1.getValue()-e2.getValue(): e2.getKey().compareTo(e1.getKey()));
        for(Map.Entry<String, Integer> e:map.entrySet()){
            // If minHeap's size is smaller than K, we just add the entry
            if(pq.size()<k){
                pq.offer(e);
            }
            // Else, we compare the current entry with "min" entry in priority queue
            else {
                if(comparator.compare(e, pq.peek())>0){
                    pq.poll();
                    pq.offer(e);
                }
            }
        }
        List<String> ans = new LinkedList<>();
        for(int i = 0;i<=k-1;i++){
            ans.add(0, pq.poll().getKey());//the "smaller" entry poll out ealier 
        }
        return ans;
    }    
}

// The comparator is reversed as maxHeap
class MyComparator implements Comparator<Map.Entry<String, Integer>> {
    public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
        String word1 = e1.getKey();
        int freq1 = e1.getValue();
        String word2 = e2.getKey();
        int freq2 = e2.getValue();
        if(freq1!=freq2){
            return freq1-freq2;
        }
        else {
            return word2.compareTo(word1);
        }
    }
}
