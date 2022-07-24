/*
You are given an array colors, in which there are three colors: 1, 2 and 3.

You are also given some queries. Each query consists of two integers i and c, return the shortest distance between the given index i and the target color c. If there is no solution return -1.

 

Example 1:

Input: colors = [1,1,2,1,3,2,2,3,3], queries = [[1,3],[2,2],[6,1]]
Output: [3,0,3]
Explanation: 
The nearest 3 from index 1 is at index 4 (3 steps away).
The nearest 2 from index 2 is at index 2 itself (0 steps away).
The nearest 1 from index 6 is at index 3 (3 steps away).
Example 2:

Input: colors = [1,2], queries = [[0,3]]
Output: [-1]
Explanation: There is no 3 in the array.
 

Constraints:

1 <= colors.length <= 5*10^4
1 <= colors[i] <= 3
1 <= queries.length <= 5*10^4
queries[i].length == 2
0 <= queries[i][0] < colors.length
1 <= queries[i][1] <= 3
https://leetcode.com/problems/shortest-distance-to-target-color/
*/
class Solution {
        public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        // initialization
        List<Integer> queryResults = new ArrayList<>();
        Map<Integer, List<Integer>> hashmap = new HashMap<>();

        for (int i = 0; i < colors.length; i++) {
            hashmap.putIfAbsent(colors[i], new ArrayList<Integer>());
            hashmap.get(colors[i]).add(i);
        }

        // for each query, apply binary search
        for (int i = 0; i < queries.length; i++) {
            int target = queries[i][0], color = queries[i][1];
            if (!hashmap.containsKey(color)) {
                queryResults.add(-1);
                continue;
            }

            List<Integer> indexList = hashmap.get(color);
            int insert = Collections.binarySearch(indexList, target);

            // due to its nature, we need to convert the returning values
            // from Collections.binarySearch
            // more details: https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Collections.html#binarySearch(java.util.List,T)
            if (insert < 0) {
                insert = (insert + 1) * -1;
            }

            // Handling cases when:
            // - the target index is smaller than all elements in the indexList
            // - the target index is larger than all elements in the indexList
            // - the target index sits between the left and right boundaries
            if (insert == 0) {
                queryResults.add(indexList.get(insert) - target);
            } else if (insert == indexList.size()) {
                queryResults.add(target - indexList.get(insert - 1));
            } else {
                int leftNearest = target - indexList.get(insert - 1);
                int rightNearest = indexList.get(insert) - target;
                queryResults.add(Math.min(leftNearest, rightNearest));
            }

        }
        return queryResults;
    }
}