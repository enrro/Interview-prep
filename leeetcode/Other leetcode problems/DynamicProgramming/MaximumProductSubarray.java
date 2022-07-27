/*
Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
https://leetcode.com/problems/maximum-product-subarray/
*/

class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        
        int maxSum = nums[0];
        int minSum = nums[0];
        int max = maxSum;
        
        for(int i = 1; i < nums.length; i++){
            int curr = nums[i];
            int tempMax = Math.max(curr, Math.max(curr * maxSum, curr * minSum));
            minSum = Math.min(curr, Math.min(curr * maxSum, curr * minSum));
            
            maxSum = tempMax;
            max = Math.max(maxSum, max);
        }
        return max;
    }
}

/*
alternative answer
* We only need to consider arrays without 0. If an array has 0 in it, then the
* array should be divided into two parts on either side of 0 because 0 cannot ever
* be included in the product.
* Example: 1,2,0,3,4,5. Max should be on either side of 0.
*
* Also, the max product array cannot ever be in the middle of an array. It has to
* be anchored to either ends of the array.
*/

    public int maxProduct(int[] A) {
        int n = A.length, res = A[0], l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            l =  (l == 0 ? 1 : l) * A[i];
            r =  (r == 0 ? 1 : r) * A[n - 1 - i];
            res = Math.max(res, Math.max(l, r));
        }
        return res;
    }