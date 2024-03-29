/*
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
https://leetcode.com/explore/interview/card/amazon/79/sorting-and-searching/2993/
*/

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) return intervals;
        // sort every element by their first value
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0],arr2[0]));
        //other sort
        //Arrays.sort(intervals, (arr1, arr2) -> (arr1[0] - arr2[0]));
        // add the first value to a list
        List<int[]> output = new ArrayList<>();
        int[] currentInterval = intervals[0];
        output.add(currentInterval);
        
        // update the list acording to the content of the intervals 
        for(int[] interval : intervals){
            int currentBegin = currentInterval[0];
            int currentEnd = currentInterval[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];
            
            if(nextBegin <= currentEnd ){
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else{
                currentInterval = interval;
                output.add(currentInterval);
            }

        }
        /** you can replece the above for with this one 
            for(int[] interval : intervals){
                if(interval[0] <= cur[1]){
                    cur[1] = interval[1];
                }else{
                    cur = interval;
                    list.add(cur);
            }
        */
        
        return output.toArray(new int[output.size()][]);
        
    }
}