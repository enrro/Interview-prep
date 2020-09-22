/*You are driving a vehicle that has capacity empty seats initially available for passengers.  The vehicle only drives east (ie. it cannot turn around and drive west.)

Given a list of trips, trip[i] = [num_passengers, start_location, end_location] contains information about the i-th trip: the number of passengers that must be picked up, and the locations to pick them up and drop them off.  The locations are given as the number of kilometers due east from your vehicle's initial location.

Return true if and only if it is possible to pick up and drop off all passengers for all the given trips. 

 

Example 1:

Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false
Example 2:

Input: trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true
Example 3:

Input: trips = [[2,1,5],[3,5,7]], capacity = 3
Output: true
Example 4:

Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
Output: true
 
 

Constraints:

trips.length <= 1000
trips[i].length == 3
1 <= trips[i][0] <= 100
0 <= trips[i][1] < trips[i][2] <= 1000
1 <= capacity <= 100000
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3467/
*/

// first aproach
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int closestDestination = 0;
        int passagers = 0, from = 0, to = 0, currentPassagers = 0, latestLocation = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        HashMap<Integer,Integer> map = new HashMap();
        Arrays.sort(trips, (a,b) -> Integer.compare(a[1],b[1]));

        // maping destination to number of passagers
        for(int[] trip : trips){
            passagers = trip[0];
            from = trip[1];
            to = trip[2];
            
            // if(from < latestLocation) return false;
            
            //drop off
            while(priorityQueue.size() != 0 && from >= priorityQueue.peek()){
                currentPassagers -= map.remove(priorityQueue.poll());
            }
            
            // add passagers
            if(!priorityQueue.contains(to))priorityQueue.add(to);
            map.put(to, map.getOrDefault(to, 0) + passagers);
            currentPassagers += passagers;
            // System.out.println(currentPassagers);
            latestLocation = from;
            // check capacity
            if(currentPassagers > capacity) return false;
            
        }
        
        return true;
    }
}

// second approach
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {    
      int stops[] = new int[1001]; 
      for (int t[] : trips) {
          stops[t[1]] += t[0];
          stops[t[2]] -= t[0];
      }
      for (int i = 0; capacity >= 0 && i < 1001; ++i) capacity -= stops[i];
      return capacity >= 0;
    }
}