/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
https://leetcode.com/explore/featured/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3769/
*/
/*
approach
First turn the input into a set of numbers. That takes O(n) and then we can ask in O(1) whether we have a certain number.

Then go through the numbers. If the number x is the start of a streak (i.e., x-1 is not in the set), then test y = x+1, x+2, x+3, ...
 and stop at the first number y not in the set. The length of the streak is then simply y-x and we update our global best with that. 
 Since we check each streak only once, this is overall O(n).


*/
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for(int i : nums) set.add(i);
        int best = 0;
        
        for(int i = 0; i < nums.length; i++){
            int x = nums[i];
            if(!set.contains(x - 1)){
                int y = x + 1;
                while(set.contains(y)){
                    y++;
                }
                best = Math.max(best, y - x);
            }
        }
        
        return best;
    }
}