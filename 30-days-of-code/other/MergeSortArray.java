/*
https://leetcode.com/problems/merge-sorted-array/
*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.out.println("n:"+ n + " m:" + m);
        while(m > 0 && n > 0){
            if(nums2[n-1] > nums1[m-1]){
                nums1[n + m - 1] = nums2[n - 1];
                n--;
            }else{
                nums1[n + m - 1] = nums1[m - 1];
                m--;
            }
        }
        
        while(n > 0){
            nums1[n-1] = nums2[n-1];
            n--;
        }
        
    }
}