/*
Container With Most Water
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49
*/

/**
AKA, the general idea to find some max is to go through all cases where max value can possibly occur
and keep updating the max value. The efficiency of the scan depends on the size of cases you plan to scan.
To increase efficiency, all we need to do is to find a smart way of scan to cut off the useless 
cases and meanwhile 100% guarantee the max value can be reached through the rest of cases.
In this problem, the smart scan way is to set two pointers initialized at both ends of the array.

Every time move the smaller value pointer to inner array. Then after the two pointers meet, all
possible max cases have been scanned and the max situation is 100% reached somewhere in the scan.
Following is a brief prove of this.

Given a1,a2,a3.....an as input array. Lets assume a10 and a20 are the max area situation. We need to prove
that a10 can be reached by left pointer and during the time left pointer stays at a10, a20 can be reached
by right pointer. That is to say, the core problem is to prove: when left pointer is at a10 and right
pointer is at a21, the next move must be right pointer to a20.

Since we are always moving the pointer with the smaller value, i.e. if a10 > a21, we should move pointer at
a21 to a20, as we hope. Why a10 >a21? Because if a21>a10, then area of a10 and a20 must be less than area
of a10 and a21. Because the area of a10 and a21 is at least height[a10] * (21-10) while the area of a10 and
a20 is at most height[a10] * (20-10). So there is a contradiction of assumption a10 and a20 has the max area.
 So, a10 must be greater than a21, then next move a21 has to be move to a20. The max cases must be reached.
https://leetcode.com/explore/interview/card/google/59/array-and-strings/3048/
 */

class Solution {
    /* approach.
        we are calculating the largest rectangle between x1 and x2.
        A rectangle area = base * height. the height is the smallest 
        height we have between x1 and x2.
        base is the distance between x1 and x2. 
    */
    public int maxArea(int[] height) {
        int x1 = 0, x2 = height.length-1;
        int max = 0;
        
        while(x1 < x2){
            int b = x2 - x1;
            int h = Math.min(height[x1], height[x2]);
            max = Math.max(max, h * b);
            if(height[x1] > height[x2]){
                x2--;
            }else{
                x1++;
            }
        }
        return max;
    }
}