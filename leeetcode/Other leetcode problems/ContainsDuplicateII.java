/*
219. Contains Duplicate II
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
https://leetcode.com/problems/contains-duplicate-ii/
*/
class Solution {
    // time O(n)
    // space O(min(n,k))
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int i = 0; i < nums.length;i++){
            if(!set.add(nums[i])){
                return true;
            }
            
            if(set.size() > k){
                set.remove(nums[i-k]);
            }
        }
        
        return false;
    }
}