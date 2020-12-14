/*
Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:

You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
Example:

Input: [3,1,5,8]
Output: 167 
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
https://leetcode.com/explore/featured/card/december-leetcoding-challenge/570/week-2-december-8th-december-14th/3564/
*/

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length+2;
        int[] A =  new int[n];
        A[0] = A[n-1] =1;
        for(int i = 0; i < nums.length; i++){
            A[i+1] = nums[i];
        }
        
        return getCoin(A,0,n-1);
    }
    
    Map<String,Integer> map = new HashMap<>();
    
    public int getCoin(int[] A, int l, int r){
        String key = l + "|" + r;
        if(!map.containsKey(key)){
            int maxCoin = 0;
            for(int i = l +1; i < r; i++){
                int score = A[l] * A[i] * A[r];
                maxCoin = Math.max(maxCoin, score + getCoin(A,l,i) + getCoin(A,i,r));
            }
            map.put(key, maxCoin);
        }
        
        
        
        return map.get(key);
    }
}