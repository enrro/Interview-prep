/*https://leetcode.com/explore/other/card/30-day-leetcoding-challenge/530/week-3/3304/*/
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