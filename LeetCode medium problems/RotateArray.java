/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Follow up:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
*/

/* 
[1,2,3,4,5,6,7] k = 3
Approach swap all the values
[7,6,5,4,3,2,1]
swap the again from 0 to k % n-1
[5,6,7,4,3,2,1]
and finally for k % n to n-1
[5,6,7,1,2,3,4]
*/
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length == 1) return;
        int n = nums.length;
        swap(nums, 0, n-1);
        swap(nums, 0, k%n-1);
        System.out.println(Arrays.toString(nums));
        swap(nums, k%n, n-1);
    }
    
    public void swap(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}