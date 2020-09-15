/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
 

Constraints:

0 <= nums.length <= 100
0 <= nums[i] <= 400
https://leetcode.com/explore/featured/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3459/
ref: https://www.youtube.com/watch?v=jzpsHKJy00c
*/
// first recursive solution. too slow because we have many overlapping problems. this solution works for small sample tests.
class Solution {
    public int rob(int[] nums) {
        return rob(nums, nums.length);
    }
    
    public int rob(int[] nums, int n){
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        
        return Math.max(rob(nums, n-1), rob(nums, n-2) +  + nums[n-1]);
    }
}

// using two variables we can keep the previous value that was the maximum, given that we always have the option to pick up the house or dont
// we keep the slower value that is v1 updated with what was v2 as a reminder of the value in case that the previous position had a larger vale.

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        
        int v1 = nums[0], v2 = Math.max(nums[1],v1);
        for(int i = 2; i < n; i++){
            int temp = v2;
            v2 = Math.max(v2, v1 + nums[i]);
            v1 = temp;
        }
        
        return v2;
    }
    
}