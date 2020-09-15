
/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible
*/
//https://leetcode.com/explore/other/card/30-day-leetcoding-challenge/531/week-4/3310/
//https://leetcode.com/explore/interview/card/google/59/array-and-strings/3053/
class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null ) return false;
        int lastGoodIndexPosition = nums.length-1;
        
        for(int i = nums.length -1; i >= 0; i--){
            if(nums[i] + i >= lastGoodIndexPosition){
                lastGoodIndexPosition = i;
            }
        }
            
        return lastGoodIndexPosition == 0;
    }
}

