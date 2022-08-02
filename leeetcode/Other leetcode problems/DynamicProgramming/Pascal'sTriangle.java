/*
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
https://leetcode.com/problems/pascals-triangle/
*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> starting = new ArrayList<Integer>();
        starting.add(1);
        out.add(starting);
        
        for(int i = 1; i < numRows;i++){
            int size = i + 1;
            List<Integer> preList = out.get(i - 1);
            List<Integer> curList = new ArrayList();
            out.add(curList);
            for(int j = 0; j < size;j++){
                int curVal = 0;
                if(j - 1 >= 0){
                    curVal += preList.get(j - 1);
                }
                if(j < preList.size()){
                    curVal += preList.get(j);
                }
                curList.add(curVal);
            }
        }
        
        return out;
    }
}
