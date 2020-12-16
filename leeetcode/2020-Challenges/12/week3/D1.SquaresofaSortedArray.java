/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
https://leetcode.com/explore/featured/card/december-leetcoding-challenge/571/week-3-december-15th-december-21st/3567/
*/

/*
Approach, we can use 2 pointers to track where in the array is the largest value. once we find the larges
we can add this value to the end of a new array and finally repeat the process moving the left or right pointer as 
we see convenient
*/
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int l = 0, r = n - 1;
        
        while(l <= r){
            if(Math.abs(nums[l]) > Math.abs(nums[r])){
                res[n-1] = nums[l] * nums[l];
                l++;
            }else{
                res[n-1] = nums[r] * nums[r];
                r--;
            }
            n--;
        }
        
        return res;
    }
}