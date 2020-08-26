/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
*/
class Solution {
    func groupAnagrams(_ strs: [String]) -> [[String]] {
        var emptyDictionary:[String:[String]] = [:]
        
        for str in strs{
            var ordered = String(str.sorted())
            print(ordered)
            if(emptyDictionary[ordered] != nil){
                emptyDictionary[ordered]?.append(str) 
            }else{
                emptyDictionary[ordered] = [str]
            }
        }
        
        return Array(emptyDictionary.values)
    }
}