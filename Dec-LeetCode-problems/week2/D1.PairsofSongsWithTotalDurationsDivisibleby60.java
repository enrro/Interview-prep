/*
You are given a list of songs where the ith song has a duration of time[i] seconds.

Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.

 

Example 1:

Input: time = [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60
Example 2:

Input: time = [60,60,60]
Output: 3
Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 

Constraints:

1 <= time.length <= 6 * 104
1 <= time[i] <= 500
https://leetcode.com/explore/featured/card/december-leetcoding-challenge/570/week-2-december-8th-december-14th/3559/
*/

/*
approach. 
keep a count of all the times a song with the required time appears. this is because every number found 
increases the convinations of numbers by 1. also keep a count that is the one that tracks every pair. 
*/
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < time.length; i++){
            int current = time[i] % 60;
            
            if(current == 0){
                count += hm.getOrDefault(current, 0);
            }else if(hm.containsKey(current)){
                count += hm.get(current);
            }
            hm.put((60 - current) % 60, hm.getOrDefault((60 - current) % 60, 0) + 1);
        }
        
        return count;
    }
}