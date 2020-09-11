/*
*/
/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

class Solution {
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    
    	public List<String> letterCombinations(String digits) {
    		List<String> ret = new LinkedList<String>();
            if(digits == null || digits.length() == 0) return ret;
    		combination("", digits, 0, ret);
    		return ret;
    	}
    
    	private void combination(String prefix, String digits, int offset, List<String> ret) {
    		if (offset >= digits.length()) {
    			ret.add(prefix);
    			return;
    		}
    		String letters = KEYS[(digits.charAt(offset) - '0')];
    		for (int i = 0; i < letters.length(); i++) {
    			combination(prefix + letters.charAt(i), digits, offset + 1, ret);
    		}
    	}
}