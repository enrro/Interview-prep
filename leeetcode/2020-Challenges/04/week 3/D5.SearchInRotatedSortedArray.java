/*
You are given an integer array nums sorted in ascending order, and an integer target.

Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

If target is found in the array return its index, otherwise, return -1.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 

Constraints:

1 <= nums.length <= 5000
-10^4 <= nums[i] <= 10^4
All values of nums are unique.
nums is guranteed to be rotated at some pivot.
-10^4 <= target <= 10^4

recursive binary search approach
https://leetcode.com/explore/other/card/30-day-leetcoding-challenge/530/week-3/3304/
*/
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        return recursiveSearch(nums, target, 0, nums.length - 1);
    }

    public int recursiveSearch(int[] nums, int target, int l, int r) {
        int m = (l + r) / 2;
        if (l > r) {
            return -1;
        }
        if (target == nums[m])
            return m;
        System.out.println("l:" + l + " m:" + m + " r:" + r);
        // check if left is ordered
        if (nums[m] > nums[l]) {
            // left < target < medium
            if (target >= nums[l] && target < nums[m]) {
                // search left
                System.out.println("search left");
                return recursiveSearch(nums, target, l, m - 1);
            } // else check other side
            else {
                System.out.println("search right");
                return recursiveSearch(nums, target, m + 1, r);
            }
        }
        // see if right is ordered.
        if (nums[m] < nums[l]) {
            // medium < target < r
            if (target > nums[m] && target <= nums[r]) {
                return recursiveSearch(nums, target, m + 1, r);
            } // else check other side
            else {
                return recursiveSearch(nums, target, l, m - 1);
            }
        } else if (nums[l] == nums[m]) { // left or right is all repeat
            if (nums[m] != nums[r]) {
                return recursiveSearch(nums, target, m + 1, r);
            } else {
                int result = recursiveSearch(nums, target, l, m - 1);
                if (result == -1) {
                    return recursiveSearch(nums, target, m + 1, r);
                } else {
                    return result;
                }
            }
        }
        return -1;
    }
}

// iterative solution 
// begin by setting what are the conditions to get into left side.
// criteria is. first is left sorted and then if so is target in
// betweeen this boundaries.
// otherwise look at the other side.
// repeat this logic with the other side.
class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int mid; 
        while(l < r){
            mid = l + (r - l) / 2;
            if(nums[mid] == target) return mid;
            if(nums[l] <= nums[mid]){
                if(target >= nums[l] && target < nums[mid]) r = mid;
                else l = mid + 1;
            }else{
                if(target <= nums[r] && target > nums[mid]) l = mid + 1;
                else r = mid;
            }
        }
        // we do the terniary operator in case the target
        // is in the first position and the array is size 0;
        // note. this is not necesary when r == nums.length
        // we cant do that this time because we access that 
        // position
        return nums[l] == target ? l : -1;
    }
}