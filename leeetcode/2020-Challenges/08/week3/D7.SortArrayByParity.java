/*
Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.

 

Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 

Note:

1 <= A.length <= 5000
0 <= A[i] <= 5000
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3431/
*/

// Approach
// 2 passes. one for odds and other for even
// O(n) additional space O(n)
class Solution {
    public int[] sortArrayByParity(int[] A) {
        if(A == null) return null;
        int[] B = new int[A.length];
        int index = 0;  
        
        for(int i = 0; i < A.length; i++){
            if(A[i] % 2 == 0){
                B[index++] = A[i];
            }
        }
        
        for(int i = 0; i < A.length; i++){
            if(A[i] % 2 != 0){
                B[index++] = A[i];
            }
        }
        
        return B;
    }
}

// Approach 2
// 2 pointers. move the odds to the end. and meet at the middle
// O(n) time. O(1) space
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int l = 0;
        int r = A.length-1;
        
        while(l <= r){
            if(A[l] % 2 != 0){
                int temp = A[l];
                A[l] = A[r];
                A[r] = temp;
                r--;
            }else{
                l++;
            }
        }
        
        return A;
    }
}