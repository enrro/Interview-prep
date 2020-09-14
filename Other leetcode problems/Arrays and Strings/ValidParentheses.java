/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
https://leetcode.com/explore/featured/card/google/59/array-and-strings/467/
*/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(char c : s.toCharArray()){
            if(c == '{' || c == '(' || c == '['){
                stack.push(c);
            }else{
                if(stack.isEmpty() 
                   || c == ')' &&  stack.peek() != '('
                   || c == '}' && stack.peek() != '{' 
                   || c == ']' && stack.peek() != '['){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}

//alternative and better
public boolean isValid(String s) {
	Stack<Character> stack = new Stack<Character>();
	for (char c : s.toCharArray()) {
		if (c == '(')
			stack.push(')');
		else if (c == '{')
			stack.push('}');
		else if (c == '[')
			stack.push(']');
		else if (stack.isEmpty() || stack.pop() != c)
			return false;
	}
	return stack.isEmpty();
}