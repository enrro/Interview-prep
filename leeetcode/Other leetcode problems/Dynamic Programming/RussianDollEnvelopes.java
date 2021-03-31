/*
You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.

One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.

Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

Note: You cannot rotate an envelope.

 

Example 1:

Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
Output: 3
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
Example 2:

Input: envelopes = [[1,1],[1,1],[1,1]]
Output: 1
 

Constraints:

1 <= envelopes.length <= 5000
envelopes[i].length == 2
1 <= wi, hi <= 104
https://leetcode.com/explore/featured/card/march-leetcoding-challenge-2021/592/week-5-march-29th-march-31st/3690/
*/

/*
approach
Sort the array. Ascend on width and descend on height if width are same.
Find the longest increasing subsequence based on height.
This problem is asking for LIS in two dimensions, width and height. Sorting the width reduces the problem by one dimension. If width is strictly increasing, the problem is equivalent to finding LIS in only the height dimension. However, when there is a tie in width, a strictly increasing sequence in height may not be a correct solution. For example, [[3,3] cannot fit in [3,4]]. Sorting height in descending order when there is a tie prevents such a sequence to be included in the solution.


**/
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return b[1] - a[1];
                }else{
                    return a[0] - b[0];
                }
            }
        });
        
        int[] dp = new int[envelopes.length];
        int len = 0;
        for(int[] envelope : envelopes){
            int i = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if(i < 0) i = -(i + 1);
            dp[i] = envelope[1];
            if(i == len) len++;
            
        }
        return len;
    }
}