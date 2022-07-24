/*
A wiggle sequence is a sequence where the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with one element and a sequence with two non-equal elements are trivially wiggle sequences.

For example, [1, 7, 4, 9, 2, 5] is a wiggle sequence because the differences (6, -3, 5, -7, 3) alternate between positive and negative.
In contrast, [1, 4, 7, 2, 5] and [1, 7, 4, 5, 5] are not wiggle sequences. The first is not because its first two differences are positive, and the second is not because its last difference is zero.
A subsequence is obtained by deleting some elements (possibly zero) from the original sequence, leaving the remaining elements in their original order.

Given an integer array nums, return the length of the longest wiggle subsequence of nums.

 

Example 1:

Input: nums = [1,7,4,9,2,5]
Output: 6
Explanation: The entire sequence is a wiggle sequence with differences (6, -3, 5, -7, 3).
Example 2:

Input: nums = [1,17,5,10,13,15,10,5,16,8]
Output: 7
Explanation: There are several subsequences that achieve this length.
One is [1, 17, 10, 13, 10, 16, 8] with differences (16, -7, 3, -3, 6, -8).
Example 3:

Input: nums = [1,2,3,4,5,6,7,8,9]
Output: 2
 

Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 1000
 https://leetcode.com/problems/wiggle-subsequence/

*/
/*
approach 
Any element in the array could correspond to only one of the three possible states:

up position, it means nums[i] > nums[i-1]nums[i]>nums[i−1]
down position, it means nums[i] < nums[i-1]nums[i]<nums[i−1]
equals to position, nums[i] == nums[i-1]nums[i]==nums[i−1]
The updates are done as:

If nums[i] > nums[i-1]nums[i]>nums[i−1], that means it wiggles up. The element before it must be a down position. So up[i] = down[i-1] + 1up[i]=down[i−1]+1, down[i]down[i] remains the same as down[i-1]down[i−1]. If nums[i] < nums[i-1]nums[i]<nums[i−1], that means it wiggles down. The element before it must be a up position. So down[i] = up[i-1] + 1down[i]=up[i−1]+1, up[i]up[i] remains the same as up[i-1]up[i−1]. If nums[i] == nums[i-1]nums[i]==nums[i−1], that means it will not change anything becaue it didn't wiggle at all. So both down[i]down[i] and up[i]up[i] remain the same as down[i-1]down[i−1] and up[i-1]up[i−1].


*/

class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[] top = new int[n];
        int[] bot = new int[n];
        top[0] = bot[0] = 1;
        
        
        for(int i = 1; i < n; i++){
            if(nums[i] > nums[i - 1]){
                top[i] = bot[i - 1] + 1;
                bot[i] = bot[i - 1];
            } else if(nums[i] < nums[i - 1]){
                bot[i] = top[i - 1] + 1;
                top[i] = top[i - 1];
            } else{
                bot[i] = bot[i - 1];
                top[i] = top[i - 1];
            }
        }
        
        return Math.max(top[n-1], bot[n-1]);
    }
}