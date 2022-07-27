/*
You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.

Return the maximum score you can get by erasing exactly one subarray.

An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).

 

Example 1:

Input: nums = [4,2,4,5,6]
Output: 17
Explanation: The optimal subarray here is [2,4,5,6].
Example 2:

Input: nums = [5,2,1,2,5,2,1,2,5]
Output: 8
Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 104
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/601/week-4-may-22nd-may-28th/3758/
*/

/*
approach sliding window. Add values until a repeated is found, then remove the value from the tail until the value at the front is removed.

*/

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet();
        int n = nums.length;
        int sum = 0;
        int max = 0;
        for(int l = 0 , r = 0; r < n; r++){
            if(set.add(nums[r])){
                sum += nums[r];
            }else{
                while(set.contains(nums[r])){
                    sum -= nums[l];
                    set.remove(nums[l++]);
                }
                sum += nums[r];
                set.add(nums[r]);
            }
            max = Math.max(sum, max);
            
        }
        
        return max;
    }
}