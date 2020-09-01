/*
Given an array of 4 digits, return the largest 24 hour time that can be made.

The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.

Return the answer as a string of length 5.  If no valid time can be made, return an empty string.

 

Example 1:

Input: [1,2,3,4]
Output: "23:41"
Example 2:

Input: [5,5,5,5]
Output: ""
 

Note:

A.length == 4
0 <= A[i] <= 9
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3445/
*/
class Solution {
    // 00:00
    // 09:59
    // 23:59
    public String largestTimeFromDigits(int[] A) {
        String result = ""; 
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 4; k++){
                    if(i == j || j == k || k == i)continue;
                    String hh = A[i] + "" + A[j];
                    // We are trying out all possible ordering, indices of 4 numbers
                    //are 0, 1, 2, and 3. um of indices = 0 + 1 + 2 + 3= 6
                    // i, j and k denote 3 indices. So, if we know 3 numbers, 
                    //the 4th number will be the remaining index, i.e., 6-i-j-k
                    String mm = A[k] + "" + A[6-i-j-k];
                    String time = hh + ":" + mm;
                    if(hh.compareTo("24") < 0 
                       && mm.compareTo("60")< 0 
                       && time.compareTo(result) > 0){
                        result = time;
                    }

                }
            }
        }
        
        return result;
    }
}