/*
Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3, t = 0
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1, t = 2
Output: true
Example 3:

Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3446/
*/
class Solution {
    //time complexity  O(nlog(min(n,k)))
    //space complexity O(min(n,k))
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet();
        for(int i = 0; i < nums.length; i++){
            Long floor = set.floor((long)nums[i]); //the max val that is smaller than current
            if(floor != null && nums[i] - floor <= t){
                return true;
            }
            Long ceiling = set.ceiling((long)nums[i]); // the min val that is greater than current
            if(ceiling != null && ceiling - nums[i] <= t){
                return true;
            }
            
            set.add((long)nums[i]);
            if(set.size() > k){
                set.remove((long)nums[i-k]);
            }
        }
        
        return false;
    }
}