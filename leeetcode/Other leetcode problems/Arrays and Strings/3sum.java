/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []
 

Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105
https://leetcode.com/explore/interview/card/google/59/array-and-strings/3049/
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>(); 
        for (int i = 0; i < nums.length-2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int lo = i+1, hi = nums.length-1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                        lo++; hi--;
                    } else if (nums[lo] + nums[hi] < sum) lo++;
                    else hi--;
               }
            }
        }
        return res;
    }
}

// another approach
// improvement. slightly optimized on positive numbers on nums[i]
// because if they are sorted and i is positive there is no positive sum that returns 0;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int  n = nums.length;
        // n - 2 because we are looking for 3 diff elements at lest.
        for(int i = 0; i < n - 2; i++){
            if(nums[i] > 0) break;
            // make sure we don't repeat a tripple by skipping elements that are the same as the last one.
            if(i == 0 || nums[i] != nums[i - 1]){
                int l = i + 1, r = n - 1, targetSum = 0 - nums[i];
                // sliding window to the target sum.
                while(l < r){
                    if(nums[l] + nums[r] == targetSum){
                        list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        // second strategy to avoid repeated numbers. skipp similar elements.
                        while (l < r && nums[l] == nums[l+1]) l++;
                        while (l < r && nums[r] == nums[r-1]) r--;
                        l++;
                        r--;
                    } else if(nums[l] + nums[r] < targetSum) l++;
                    else r--;
                }
            }
        }
        
        return list;
    }
}