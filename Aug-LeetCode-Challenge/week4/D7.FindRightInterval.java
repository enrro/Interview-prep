/*
Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.

For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.

Note:

You may assume the interval's end point is always bigger than its start point.
You may assume none of these intervals have the same start point.
 

Example 1:

Input: [ [1,2] ]

Output: [-1]

Explanation: There is only one interval in the collection, so it outputs -1.
 

Example 2:

Input: [ [3,4], [2,3], [1,2] ]

Output: [-1, 0, 1]

Explanation: There is no satisfied "right" interval for [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point;
For [1,2], the interval [2,3] has minimum-"right" start point.
 

Example 3:

Input: [ [1,4], [2,3], [3,4] ]

Output: [-1, 2, -1]

Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3438/
*/

/*
First Approach.
The first approach consist of comparing every element in the array with every other element. this would take us n^2 time because we have to look all neighbors since we dont know whether there is a larger one to the left because they are not sorted.

Second Approach.
We sort this values and save the index at where they where found.
Save all the values as pairs of pairs. the first pair contains the values in the array. the second contains the index in the array where it was found.
Now we sort this values. 
[ [3,4], [2,3], [1,2] ]
[ [1,2], [2,3], [3,4] ]
After we have sort this values now we can find easily the values that belong to the largest or equals to the last element in the pair because we now only need to look at one side of the array and we know the length of this array and that everything here is sorted we can do a binary search.
*/
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        List<Pair<Pair<Integer,Integer>,Integer>> sorted = new ArrayList();
        int n = intervals.length;
        for(int i =0; i < n ; ++i){
            sorted.add(new Pair(new Pair(intervals[i][0],intervals[i][1]),i));
        }
        // a.getKey() gets interval 
        // a.getKey().getKey() gets the begining of the interval
        Collections.sort(sorted, (a,b) -> a.getKey().getKey() - b.getKey().getKey());
        int[] results = new int[n];
        for(int i = 0; i < n; ++i){
            results[i] = binarySearch(sorted, intervals[i][1]);
        }
        return results;
    }
    
    int binarySearch(List<Pair<Pair<Integer,Integer>,Integer>> sorted, int x){
        int n = sorted.size();
        if(sorted.get(n-1).getKey().getKey() < x) return -1;
        
        int l = 0, r = n - 1;
        while(l <= r){
            // avoid overflow with this mid funcion or this int mid = (low + high) >>> 1;
            int mid = l + (r-l)/2;
            if(sorted.get(mid).getKey().getKey() >= x) r = mid-1;
            else l = mid + 1;
        }
        return sorted.get(l).getValue();
    }
}