/*
Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

 

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1
 

Constraints:

1 <= intervals.length <= 104
0 <= starti < endi <= 106
https://leetcode.com/explore/interview/card/amazon/79/sorting-and-searching/497/
*/

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        
        for(int i = 0; i < n; i++){
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        int room = 0;
        
        // if a meeting starts before the last one ends then we need another room.
        // else if a meeting ends after the last one is finished. we can keep going
        for(int startIndex = 0, endIndex = 0; startIndex < n; startIndex++){
            if(starts[startIndex] < ends[endIndex]){
                room++;
            } else{
                endIndex++;
            }
        }
        
        return room;
    }
}