/*
Also known as Find First and Last Position of Element in Sorted Array
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums is a non decreasing array.
-10^9 <= target <= 10^9
https://leetcode.com/explore/learn/card/binary-search/135/template-iii/944/
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        int mid;
        int x, y;
        
        while(l < r){
            mid = l + (r - l) / 2;
        // left is going to iterate until it finds the value that is target
            if(nums[mid] >= target){
                r = mid;
            }else{
                l = mid + 1;
            }
            System.out.println("l: " + l + " r: " + r);
        }
        x = l;
        
        r = nums.length;
        
        while(l < r){
            mid = l + (r - l) / 2;
        // left is going to iterate until it finds the value that is larget than target
            if(nums[mid] > target){
                r = mid;
            }else{
                l = mid + 1;
            }
            System.out.println("l: " + l + " r: " + r);
        }
        
        y = l;
        
        return x == y ? new int[]{-1,-1} : new int[]{x,y-1};
    }
}