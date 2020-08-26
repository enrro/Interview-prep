/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/
class Solution {
    func maxSubArray(_ nums: [Int]) -> Int {
        var max = Int.min
        var current = 0
        
        for i in 0..<nums.count{
            current += nums[i]
            if(current > max){
                max = current
            }
            if(current < 0){
                current = 0
            }
        }
        
        return max
    }
}