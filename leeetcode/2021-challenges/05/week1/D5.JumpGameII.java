/*
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
 

Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 105
*/

class Solution {
    // approach implicit bfs solution
    // i > curEnd; once all the items on the current level have been visited we have to jump
    // curEnd = curFarthest; is like getting the queue size (level size) for the
    // next level you are traversing
    public int jump(int[] nums) {
        
        
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
            curFarthest = Math.max(curFarthest, i + nums[i]);
        }
        return jumps;        
    }
}