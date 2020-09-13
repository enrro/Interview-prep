/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
https://leetcode.com/explore/featured/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3457/
*/

class Solution {
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> out = new LinkedList();
        List<Integer> current = new LinkedList();
        combination(k,n,1,out,current);
        return out;
    }
    
    public void combination(int k, int n, int a, List<List<Integer>> out, List<Integer> current) {
        if(current.size() == k){
            if(n == 0) out.add(new LinkedList<Integer>(current));
            return;
        }
        
        
        for(int i = a; i <= 9; i++){
            current.add(i);
            combination(k,n-i,i+1,out,current);
            current.remove(current.size()-1);
        }
    }
}