/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
*/

/**
* * approach
input: [2,0,1,0,3,1,0,2,2,0,5]
there are two possible conditions that can happend once you find which side is larger
Condition 1: there exists another bar with height h, as 2 < h < 5, then position 1 can fill water with 2 units, even though water will be blocked by the middle bar
Condition 2: there exists another bar with height h, as 2 > h, then position 1 still can fill water with 2 units (in other words, if there does not exist any bars greater than 2, then water will fill out every position until reach the right most bar with height 5)
So anything in the middle of leftMax bar and rightMax bar will not influence how much water can current position trap
 */
class Solution {
    public int trap(int[] height) {
        int head = height.length-1, tail = 0, max = 0, headMax = 0, tailMax = 0;
        
        while(tail < head){
            tailMax = Math.max(tailMax, height[tail]);
            headMax = Math.max(headMax, height[head]);
            
            if(tailMax < headMax){
                max += tailMax - height[tail];
                tail++;
            }else{
                max += headMax - height[head];
                head--;
            }
            
        }
        
        return max;
    }
}