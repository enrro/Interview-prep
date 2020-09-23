/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]
https://leetcode.com/explore/featured/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3469/
*/

class Solution {
    // * * aproach: Boyer-Moore Majority Vote algorithm
    public List<Integer> majorityElement(int[] nums) {
        int candA = 0, candB = 0, maxA = 0, maxB = 0;
        List<Integer> list = new LinkedList();
        
        for(int i = 0; i < nums.length;i++){
            if(nums[i] == candA){
                maxA++;
            }else if(nums[i] == candB){
                maxB++;
            }else if(maxA == 0){
                candA = nums[i];
                maxA++;
            }else if(maxB == 0){
                candB = nums[i];
                maxB++;
            }else{
                maxB--;
                maxA--;
            }
        }
        
        // System.out.println(candA);
        // System.out.println(candB);

        maxA = 0;
        maxB = 0;
        
        for(int num : nums){
            if(num == candA){
                maxA++;
            }else if(num == candB){
                maxB++;
            }
        }
        
        if(maxA > nums.length / 3)list.add(candA);
        if(maxB > nums.length / 3)list.add(candB);
        return list;
    }
}