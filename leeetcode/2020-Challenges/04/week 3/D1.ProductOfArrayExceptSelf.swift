/*
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
*/

class Solution {
    func productExceptSelf(_ nums: [Int]) -> [Int] {
        var ans: [Int] = Array(repeating: 0, count: nums.count)
        ans[0] = 1
        
        for i in 1..<nums.count{
            ans[i] = ans[i-1] * nums[i-1]
        }
        var R = 1
        // the array that goes from [count-1,...0]
        for j in (0..<nums.count-1).reversed(){
            R  *= nums[j+1]
            ans[j] *= R
        }
        
        return ans
    }
}

/* 
// most intuitive 2 arrays version
class Solution {
    func productExceptSelf(_ nums: [Int]) -> [Int] {
        var R: [Int] = Array(repeating: 0, count: nums.count)
        var L: [Int] = Array(repeating: 0, count: nums.count)
        var total: [Int] = Array(repeating: 0, count: nums.count)
        
        L[0] = 1
        for i in 1..<nums.count{
            L[i] = L[i-1] * nums[i-1]
        }
        print(L)

        R[R.count-1] = 1
        //for i in stride(from: R.count-2, through: 0, by: -1){
        for i in (0...nums.count-2).reversed(){
            print(i)
            R[i] = R[i+1] * nums[i+1]
        }
        print(R)
        
        for i in 0..<nums.count{
            total[i] = L[i] * R[i]
        }
        return total
    }
}
*/