/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
https://leetcode.com/explore/featured/card/april-leetcoding-challenge-2021/594/week-2-april-8th-april-14th/3701/
*/

class Solution {
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        LinkedList<String> output = new LinkedList();
        if(digits == null || digits.length() == 0) return output;
        combination(digits,0, "",output);
        return output;
    }
    
    public void combination(String digits, int index,String temp, LinkedList output){
        if(index == digits.length()){
            output.add(temp);
            return;
        }
        
        String letters = KEYS[digits.charAt(index) - '0'];
        for(int i = 0; i < letters.length(); i++){
            combination(digits, index + 1, temp + letters.charAt(i), output);
        }
    }
}