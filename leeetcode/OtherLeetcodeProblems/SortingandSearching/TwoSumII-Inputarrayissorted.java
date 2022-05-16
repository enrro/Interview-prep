/*
  Two Sum II - Input array is sorted

Given an array of integers numbers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

Return the indices of the two numbers (1-indexed) as an integer array answer of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.

You may assume that each input would have exactly one solution and you may not use the same element twice.

 

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
 

Constraints:

2 <= numbers.length <= 3 * 104
-1000 <= numbers[i] <= 1000
numbers is sorted in increasing order.
-1000 <= target <= 1000
Only one valid answer exists.
https://leetcode.com/explore/interview/card/amazon/79/sorting-and-searching/2994/
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length-1;
        int[] indice = new int[2];
        if (numbers == null || numbers.length < 2) return indice;
        while(l < r){
            int value = numbers[l] + numbers[r];
            if(value == target){
                indice[0] = l+1;
                indice[1] = r+1;
                return indice;
            }
            else if(value > target){
                r--;
            }else{
                l++;
            }
        }
        
        return indice;
    }
}