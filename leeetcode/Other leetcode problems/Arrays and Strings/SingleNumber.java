/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?

 

Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1
 

Constraints:

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.
https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/549/
 */
// known that A XOR A = 0 and the XOR operator is commutative, the solution will be very straightforward.
/*
Let's say we have an array - [2,1,4,5,2,4,1].
What we are doing is essentially this-

=> 0 ^ 2 ^ 1 ^ 4 ^ 5 ^ 2 ^ 4 ^ 1

=> 0^ 2^2 ^ 1^1 ^ 4^4 ^5 (Rearranging, taking same numbers together)

=> 0 ^ 0 ^ 0 ^ 0 ^ 5

=> 0 ^ 5

=> 5 :)
*/
class Solution {
    public int singleNumber(int[] nums) {
        int xor = nums[0];
        for(int i = 1; i < nums.length; i++){
            xor ^= nums[i];
        }
        
        return xor;
    }
}