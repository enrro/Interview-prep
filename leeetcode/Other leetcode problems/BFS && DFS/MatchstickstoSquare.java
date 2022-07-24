/*
You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. You want to use all the matchsticks to make one square. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

Return true if you can make this square and false otherwise.

 

Example 1:


Input: matchsticks = [1,1,2,2,2]
Output: true
Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
Example 2:

Input: matchsticks = [3,3,3,3,4]
Output: false
Explanation: You cannot find a way to form a square with all the matchsticks.
 

Constraints:

1 <= matchsticks.length <= 15
1 <= matchsticks[i] <= 108

https://leetcode.com/problems/matchsticks-to-square/

*/

/*
approach
dfs. try to give a value to every side possible in the square.
if its beyond the target value pass it to the next side
*/

class Solution {
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks.length < 4) return false;
        int sum = 0;
        for(int match: matchsticks) sum+= match;
        if(sum % 4 != 0) return false;
        
        Arrays.sort(matchsticks);
        revert(matchsticks);
        System.out.println(Arrays.toString(matchsticks));
        return dfs(matchsticks, new int[4], 0, sum / 4);
    }
    
    public boolean dfs(int[]matches, int[] sides, int matchIndex, int target){
        if(matchIndex == matches.length){
            if(sides[0] == target && sides[1] == target && sides[2] == target){
                return true;
            }else{
                return false;
            }
        }
        
        for(int sideIndex = 0; sideIndex < 4; sideIndex++){
            if(sides[sideIndex] + matches[matchIndex] > target) continue;
            sides[sideIndex] += matches[matchIndex];
            if(dfs(matches, sides, matchIndex + 1, target)){
                return true;
            }
            sides[sideIndex] -= matches[matchIndex];
        }
        return false;
    }
    
    
    public void revert(int[] ar){
        int i = 0, j = ar.length - 1;
        while(i < j){
            int temp = ar[i];
            ar[i] = ar[j];
            ar[j] = temp;
            i++;
            j--;
        }
        
    }
}