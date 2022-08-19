/**
You are given an integer array nums that is sorted in non-decreasing order.

Determine if it is possible to split nums into one or more subsequences such that both of the following conditions are true:

Each subsequence is a consecutive increasing sequence (i.e. each integer is exactly one more than the previous integer).
All subsequences have a length of 3 or more.
Return true if you can split nums according to the above conditions, or false otherwise.

A subsequence of an array is a new array that is formed from the original array by deleting some (can be none) of the elements without disturbing the relative positions of the remaining elements. (i.e., [1,3,5] is a subsequence of [1,2,3,4,5] while [1,3,2] is not).

 

Example 1:

Input: nums = [1,2,3,3,4,5]
Output: true
Explanation: nums can be split into the following subsequences:
[1,2,3,3,4,5] --> 1, 2, 3
[1,2,3,3,4,5] --> 3, 4, 5
Example 2:

Input: nums = [1,2,3,3,4,4,5,5]
Output: true
Explanation: nums can be split into the following subsequences:
[1,2,3,3,4,4,5,5] --> 1, 2, 3, 4, 5
[1,2,3,3,4,4,5,5] --> 3, 4, 5
Example 3:

Input: nums = [1,2,3,4,4,5]
Output: false
Explanation: It is impossible to split nums into consecutive increasing subsequences of length 3 or more.
 

Constraints:

1 <= nums.length <= 104
-1000 <= nums[i] <= 1000
nums is sorted in non-decreasing order.

https://leetcode.com/problems/split-array-into-consecutive-subsequences/
 */

 class Solution {
    public boolean isPossible(int[] nums) {
        PriorityQueue<int[]> subsequences = new PriorityQueue<>((int[] a, int[] b) -> a[1] == b[1]? (a[1] - a[0]) - (b[1] - b[0]): a[1] - b[1]);
        /**
        PriorityQueue<int[]> subsequences = new PriorityQueue<>((int[] subsequence1, int[] subsequence2) -> {
            if (subsequence1[1] == subsequence2[1]) {
                return (subsequence1[1] - subsequence1[0]) - (subsequence2[1] - subsequence2[0]);
            }
            return (subsequence1[1] - subsequence2[1]);
        });
         */
        for (int num : nums) {
            // Condition 1 - remove non-qualifying subsequences 
            while (!subsecuencia.isEmpty() && subsecuencia.peek()[1] + 1 < num) {
                int[] currentSubsequence = subsecuencia.poll();
                int subsequenceLength = currentSubsequence[1] - currentSubsequence[0] + 1;
                if (subsequenceLength < 3) {
                    return false;
                }
            }
            //Condition 2 - create a new subsequence
            if (subsecuencia.isEmpty() || subsecuencia.peek()[1] == num) {
                subsecuencia.add(new int[]{num, num});
            } else {
                // Condition 3 - add num to an existing subsequence
                int[] currentSubsequence = subsecuencia.poll();
                subsecuencia.add(new int[]{currentSubsequence[0], num});
            }
        }

        // If any subsequence is of length less than 3, return false
        while (!subsecuencia.isEmpty()) {
            int[] currentSubsequence = subsecuencia.poll();
            int subsequenceLength = currentSubsequence[1] - currentSubsequence[0] + 1;
            if (subsequenceLength < 3) {
                return false;
            }
        }

        return true;
    }
}

// greedy with maps
class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> subsequences = new HashMap<>();
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            //num already part of a valid subsequence.
            if (frequency.get(num) == 0) {
                continue;
            }
            // If a valid subsequence exists with the last element = num - 1.
            if (subsequences.getOrDefault(num - 1, 0) > 0) {
                subsequences.put(num - 1, subsequences.getOrDefault(num - 1, 0) - 1);
                subsequences.put(num, subsequences.getOrDefault(num, 0) + 1);
            } else if (frequency.getOrDefault(num + 1, 0) > 0 && 
                       frequency.getOrDefault(num + 2, 0) > 0) {
                // If we want to start a new subsequence, check if num + 1 and num + 2 exist.
                // Update the list of subsequences with the newly created subsequence
                subsequences.put(num + 2, subsequences.getOrDefault(num + 2, 0) + 1);
                frequency.put(num + 1, frequency.getOrDefault(num + 1, 0) - 1);
                frequency.put(num + 2, frequency.getOrDefault(num + 2, 0) - 1);
            } else {
                //No valid subsequence is possible with num
                return false;
            }
            frequency.put(num, frequency.get(num) - 1);
        }
        return true;
    }
}