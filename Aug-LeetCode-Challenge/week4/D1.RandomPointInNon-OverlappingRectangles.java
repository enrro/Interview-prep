/*
Given a list of non-overlapping axis-aligned rectangles rects, write a function pick which randomly and uniformily picks an integer point in the space covered by the rectangles.

Note:

An integer point is a point that has integer coordinates. 
A point on the perimeter of a rectangle is included in the space covered by the rectangles. 
ith rectangle = rects[i] = [x1,y1,x2,y2], where [x1, y1] are the integer coordinates of the bottom-left corner, and [x2, y2] are the integer coordinates of the top-right corner.
length and width of each rectangle does not exceed 2000.
1 <= rects.length <= 100
pick return a point as an array of integer coordinates [p_x, p_y]
pick is called at most 10000 times.
Example 1:

Input: 
["Solution","pick","pick","pick"]
[[[[1,1,5,5]]],[],[],[]]
Output: 
[null,[4,1],[4,1],[3,3]]
Example 2:

Input: 
["Solution","pick","pick","pick","pick","pick"]
[[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
Output: 
[null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]]
Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array of rectangles rects. pick has no arguments. Arguments are always wrapped with a list, even if there aren't any.
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3433/
*/

class Solution {
    int numPnts;
    ArrayList<Integer> acumulativePoints = new ArrayList<Integer>();
    int[][] rects;
    
    // for every rectangle add the number of points that each has.
    // and add them to a counter to keep track of the whole amount and to an array list to know 
    // where one rectangle starts and one ends. 
    // we can pick a rnd number between 0 and numPnts to select the rectangle and then map the 
    // rnd number to the position of the point in that rectangle.
    public Solution(int[][] rects) {
        numPnts = 0;
        this.rects = rects;

        for(int[] rect : this.rects){
            numPnts += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1 );
            acumulativePoints.add(numPnts);
        }
    }
    
    public int[] pick() {
        int pointIndex = (int) (Math.random() * numPnts);
        int l = 0;
        int r = rects.length - 1;
        
        while(l < r){
            int mid = l + (r-l)/2;
            if(acumulativePoints.get(mid) <= pointIndex) l = mid + 1;
            else r = mid;
        }
        // l will hold rectangule index
        int[] rect = rects[l];
        int xPoints = rect[2] - rect[0] + 1;
        int yPoints = rect[3] - rect[1] + 1;
        int pointsInRect = xPoints * yPoints;
        int ptStart = acumulativePoints.get(l) - pointsInRect;
        int offset = pointIndex - ptStart;

        return new int[]{rect[0] + (offset%xPoints), rect[1] + (offset/xPoints)};
    }
}

/**
https://www.youtube.com/watch?v=8kwPXbTMSnk
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */