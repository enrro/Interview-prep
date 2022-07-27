/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length; 
        int[] res = new int[2];
        while(l < r){
            int mid = l +(r - l) / 2;
            
            if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        
        res[0] = l;
        r = nums.length;
        
        while(l < r){
            int mid = l +(r - l) / 2;
            
            if(nums[mid] <= target){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        if(res[0] == l) return new int[]{-1, -1};
        res[1] = l - 1;
        return res;
    }
}