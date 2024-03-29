/*

You are given a rectangular cake of size h x w and two arrays of integers horizontalCuts and verticalCuts where:

horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut and similarly, and
verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.
Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided in the arrays horizontalCuts and verticalCuts. Since the answer can be a large number, return this modulo 109 + 7.

 

Example 1:


Input: h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
Output: 4 
Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the green piece of cake has the maximum area.
Example 2:


Input: h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
Output: 6
Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the green and yellow pieces of cake have the maximum area.
Example 3:

Input: h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
Output: 9
 

Constraints:

2 <= h, w <= 109
1 <= horizontalCuts.length <= min(h - 1, 105)
1 <= verticalCuts.length <= min(w - 1, 105)
1 <= horizontalCuts[i] < h
1 <= verticalCuts[i] < w
All the elements in horizontalCuts are distinct.
All the elements in verticalCuts are distinct.
https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
*/

class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int nhc = horizontalCuts.length, nvc = verticalCuts.length;
        int maxHorizontal = 0, maxVertical = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        maxHorizontal = Math.max(horizontalCuts[0], h - horizontalCuts[nhc - 1]);
        maxVertical = Math.max(verticalCuts[0], w - verticalCuts[nvc - 1]);
        
        for(int i = 1; i < nhc; i++){
            maxHorizontal = Math.max(maxHorizontal, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        
        for(int i = 1; i < nvc; i++){
            maxVertical = Math.max(maxVertical, verticalCuts[i] - verticalCuts[i - 1]);
        }
        
        return (int)((long)  maxHorizontal * maxVertical % 1000000007);
    }
}