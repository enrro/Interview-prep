/*
You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:

numberOfBoxesi is the number of boxes of type i.
numberOfUnitsPerBoxi is the number of units in each box of the type i.
You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.

Return the maximum total number of units that can be put on the truck.

 

Example 1:

Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
Output: 8
Explanation: There are:
- 1 box of the first type that contains 3 units.
- 2 boxes of the second type that contain 2 units each.
- 3 boxes of the third type that contain 1 unit each.
You can take all the boxes of the first and second types, and one box of the third type.
The total number of units will be = (1 * 3) + (2 * 2) + (1 * 1) = 8.
Example 2:

Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
Output: 91
 

Constraints:

1 <= boxTypes.length <= 1000
1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000
1 <= truckSize <= 106
https://leetcode.com/problems/maximum-units-on-a-truck/
*/
/*
Approach.
we sort the array by highest number of boxes first.
Integer.compare(b[1],a[1]);
when we do compare if we add the second comparable variable first this means that 
we are sorting from highest to lowest also know as reverse order.
Collections.reverseOrder()
*/

// fewest lines solution Comparator with lambda expressions

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> Integer.compare(b[1],a[1]));
        int noUnits = 0;
        int usedSpace = 0;
        for(int[] box : boxTypes){
            if(usedSpace >= truckSize)break;
            int spaceLeft = truckSize -  usedSpace;
            int units = box[1];
            int boxes = box[0];
            
            noUnits += spaceLeft < boxes ? (spaceLeft * units) : (boxes * units);

            usedSpace += boxes;
        }
        
        return noUnits;
    }
}

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>(){
           @Override
            public int compare(int[] a, int[] b){
                return b[1] - a[1];
            }
        });
        
        for(int[] box : boxTypes){
            heap.add(box);
        }
        
        int res = 0;
        int usedSpace = 0;
        while(!heap.isEmpty() && usedSpace < truckSize){
            int[] box = heap.poll();
            // System.out.println(Arrays.toString(box));
            // System.out.println(usedSpace);

            int spaceLeft = truckSize -  usedSpace;
            
            if(spaceLeft < box[0]){
                res = res + (spaceLeft * box[1]);
            }else{
                res = res + (box[0] * box[1]);
            }
            usedSpace += box[0];
        }
        
        return res;
    }
}

