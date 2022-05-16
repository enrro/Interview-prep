/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
Example 3:

Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000
Example 4:

Input: nums1 = [], nums2 = [1]
Output: 1.00000
Example 5:

Input: nums1 = [2], nums2 = []
Output: 2.00000
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
https://leetcode.com/explore/interview/card/amazon/79/sorting-and-searching/2991/
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // create an array with size a + b. // pick the middle value
        int m = nums1.length, n = nums2.length;
        int a = 0, b = 0, c = 0;
        int[] res = new int[m + n];
        
        while(a < m && b < n){
            if(nums1[a] < nums2[b]){
                res[c++] = nums1[a++];
            }else{
                res[c++] = nums2[b++];
            }
        }
        
        while(a < m) res[c++] = nums1[a++];
        while(b < n) res[c++] = nums2[b++];
        
        // c is the size of the res
        if(res.length % 2 == 1){
            return res[c / 2];
        }else{
            return ((double) res[c / 2 - 1] + res[c / 2]) / 2;
        }
    }
}