/*
Given an m x n matrix mat where every row is sorted in strictly increasing order, return the smallest common element in all rows.

If there is no common element, return -1.

 

Example 1:

Input: mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
Output: 5
Example 2:

Input: mat = [[1,2,3],[2,3,4],[2,3,5]]
Output: 2
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 500
1 <= mat[i][j] <= 104
mat[i] is sorted in strictly increasing order.
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/591/week-4-march-22nd-march-28th/3680/
*/

class Solution {
    public int smallestCommonElement(int[][] mat) {
        for (int i: mat[0]){
            boolean found = true;
            for (int j = 0; j< mat.length; j++) {
                if (!binarySearch(mat[j], i)) {
                    found = false;
                    break;
                }
            }
            if(found) return i;
        }
        return -1;
    }
    
    public boolean binarySearch(int[] row, int target){
        int left = 0,  right = row.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(row[mid] == target)return true;
            if(row[mid] > target)right = mid - 1;
            else if(row[mid] < target)left = mid + 1;
        }
        return false;
    }
}