/*
Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.

We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).

 

Example 1:

Input: nums = [4,2,3]
Output: true
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
Example 2:

Input: nums = [4,2,1]
Output: false
Explanation: You can't get a non-decreasing array by modify at most one element.
 

Constraints:

n == nums.length
1 <= n <= 104
-105 <= nums[i] <= 105
*/
class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean flag = false;
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            max = Math.max(max, nums[i]);
            
            if(nums[i - 1] > nums[i] ){
                /* eaither you trigger the flag twice or 
                two values before it was larger than current and 
                the next value is larger than the previous
                */
                if(flag || (i > 1 && i < nums.length - 1 && nums[i-2] > nums[i] &&  nums[i+1] < nums[i-1])){
                    return false;
                }
                flag = true;
            }
        }
        return true;
    }
    
    /* if two values before it was larger than current is false but  the next value is larger than the previous
    that means that we need to change the previous value to current.
    in conclusion there are two main cases, the first is to change current or remove current or the other that is to remove previous.
    
    */
}