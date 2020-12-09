/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

1. You must do this in-place without making a copy of the array.
2. Minimize the total number of operations.
*/

class Solution {
    func moveZeroes(_ nums: inout [Int]) {
        var lastNonZeroFoundAt = 0
        
        // we move all non zero elements at the beginning of the array
        for i in 0...nums.count - 1 {
            if nums[i] != 0 {
                nums[lastNonZeroFoundAt] = nums[i];
                lastNonZeroFoundAt += 1

            }
        }
        
        print(lastNonZeroFoundAt)
        // we fill with 0s from where we left. 
        for i in lastNonZeroFoundAt..<nums.count {
            nums[i] = 0
        }
    }
}