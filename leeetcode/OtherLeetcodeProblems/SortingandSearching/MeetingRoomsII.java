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
        int[] startTime = new int[n];
        int[] endTime = new int[n];
        
        for(int i = 0; i < n; i++){
            startTime[i] = intervals[i][0];
            endTime[i] = intervals[i][1];
        }
        
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        int rooms = 0;
        int endsItr = 0;
        
        for(int i = 0; i < n; i++){
            if(startTime[i]<endTime[endsItr]){
                rooms++;
            }else{
                endsItr++;
            }

        }
        
        return rooms;
    }
}