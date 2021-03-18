/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
Example 4:

Input: coins = [1], amount = 1
Output: 1
Example 5:

Input: coins = [1], amount = 2
Output: 2
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
https://leetcode.com/explore/interview/card/amazon/80/dynamic-programming/2998/
*/


/*
approach
we create an array of size amount + 1 and look for the minimum number of coins needed to form that quantity every time
so for a coin value 1 to form the amount 12 it will take 12 coins but for a coin value 2 it will take only 6 coins.
we update this min value for each new coin there is. 

big O(n*amount) time O(amount) space
*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); 
        dp[0] = 0; 
        for(int j = 0; j < coins.length; j++){
            for(int i = 0; i <= amount; i++){
                if(i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    // System.out.println("i: " + i +"\tMath.min: " + Math.min(dp[i], dp[i - coins[j]] + 1));
                }
            } 
        }
        // System.out.println(Arrays.toString(dp));
        return dp[amount] > amount ? -1 : dp[amount];
    }
}