/*
Maximum Product Subarray

Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
https://leetcode.com/explore/featured/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3456/
*/

/*approach
Here are my observations:

It's really about odd negative numbers or even negative numbers, if it's odd, either the left end one or the right end one should be counted,
so it will be revealed by scanning from left and from right in 2 passes.

0 is a kind of delimiter, product accumulation will be reset to 1
*/
class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int l = 0, r  = 0;
        for(int i = 0; i < nums.length; i++){
            l = (l == 0 ? 1 : l) * nums[i];
            r = (r == 0 ? 1 : r) * nums[nums.length -1 -i];
            max = Math.max(max, Math.max(l,r));
        }
        
        return max;
    }
}