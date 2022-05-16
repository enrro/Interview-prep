/*
Design a data structure that will be initialized with a string array, and then it should answer queries of the shortest distance between two different strings from the array.

Implement the WordDistance class:

WordDistance(String[] wordsDict) initializes the object with the strings array wordsDict.
int shortest(String word1, String word2) returns the shortest distance between word1 and word2 in the array wordsDict.
 

Example 1:

Input
["WordDistance", "shortest", "shortest"]
[[["practice", "makes", "perfect", "coding", "makes"]], ["coding", "practice"], ["makes", "coding"]]
Output
[null, 3, 1]

Explanation
WordDistance wordDistance = new WordDistance(["practice", "makes", "perfect", "coding", "makes"]);
wordDistance.shortest("coding", "practice"); // return 3
wordDistance.shortest("makes", "coding");    // return 1
 

Constraints:

1 <= wordsDict.length <= 3 * 104
1 <= wordsDict[i].length <= 10
wordsDict[i] consists of lowercase English letters.
word1 and word2 are in wordsDict.
word1 != word2
At most 5000 calls will be made to shortest.
https://leetcode.com/problems/shortest-word-distance-ii/
*/

/*
approach.
since there can be many similar words we keep a list of all of the index where 
we find this word in a map. the map reads from word to list of index. 
With the input we retrieve the list and iterate throught the list looking for the smallest 
value;
*/
class WordDistance {
    private HashMap<String, List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        map = new HashMap<String, List<Integer>>();
        
        for(int i = 0; i < wordsDict.length; i++){
            String word = wordsDict[i];
            
            if(map.containsKey(word)){
                List<Integer> list = map.get(word);
                list.add(i);
            }
            else{
                List<Integer> list = new ArrayList();
                list.add(i);
                map.put(word, list);
            }
        }
        
    }
    
    public int shortest(String word1, String word2) {
        int res = Integer.MAX_VALUE;
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        
        for(int i = 0, j = 0; i < list1.size() && j < list2.size(); ){
            int index1 = list1.get(i), index2 = list2.get(j);
            
            if(index1 < index2){
                res = Math.min(index2 - index1, res);
                i++;
            }else{
                res = Math.min(index1 - index2, res);
                j++;
            }
        }
        
        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */