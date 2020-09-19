/*A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 
or index number 5 where the peak element is 6.
Follow up: Your solution should be in logarithmic complexity.
https://leetcode.com/explore/learn/card/binary-search/126/template-ii/948/
*/

/*
https://leetcode.com/explore/learn/card/binary-search/126/template-ii/948/discuss/50232/Find-the-maximum-by-binary-search-(recursion-and-iteration)
What we are essentially doing is going in the direction of the rising slope(by choosing the element which is greater than current). How does that
 guarantee the result? Think about it, there are 2 possibilities.a) rising slope has to keep rising till end of the array b) rising slope will
encounter a lesser element and go down.
In both scenarios we will have an answer. In 
a) the answer is the end element because we take the boundary as -INFINITY
b) the answer is the largest element before the slope falls. Hope this makes things clearer

The idea is that, when you are at the middle element and you see the next element is above you(imagine this as a hill),
you bring left(pointer) to this (mid+1) convinced that since element at mid is less, so element at mid+1 can be a peak, we just have to confirm with the right pointer.

*/
class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int mid1;
        int mid2;
        while(l < r){
            mid1 = l + (r-l)/2;
            mid2 = mid1 + 1;

            if(nums[mid1] < nums[mid2]){
                l = mid2;
            }else{
                r = mid1;
            }
        }
        return l;
    }
}
class Solution {
    /*
    The idea is that, when you are at the middle element and you see the next element
    is above you(imagine this as a hill),
    you bring left(pointer) to this (mid+1) convinced that since element at mid is less,
    so element at mid+1 can be a peak, we just have to confirm with the right pointer.
    */
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length-1, mid = 0;
        
        while(l < r){
            mid = l + (r - l) / 2;
            if(nums[mid] < nums[mid+1]){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        return l;
    }
}