/*
You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.

Return the minimum number of operations to reduce x to exactly 0 if it's possible, otherwise, return -1.

 

Example 1:

Input: nums = [1,1,4,2,3], x = 5
Output: 2
Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
Example 2:

Input: nums = [5,6,7,8,9], x = 4
Output: -1
Example 3:

Input: nums = [3,2,20,1,1,3], x = 10
Output: 5
Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 104
1 <= x <= 109
https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
*/
/*
approach
if left + right == x then totalSum - x == left + right 
we want a distance such that Math.min(left + right = x)
which is equivalent to lengthOfArray - Math.max(totalSumofAll - x);
*/
class Solution {
    public int minOperations(int[] nums, int x) {
        int target = Arrays.stream(nums).sum()-x;
        int wSize = -1, current = 0;
        
        for(int right = 0, left = 0; right < nums.length;right++){
            current += nums[right];
            while(current > target && left <= right)
                current -= nums[left++];
            if(current == target)
                wSize = Math.max(wSize,right - left + 1);
            
        }
        return wSize != -1 ? nums.length - wSize : -1;
    }
}