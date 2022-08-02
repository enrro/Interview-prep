/*
An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return the nth ugly number.

 

Example 1:

Input: n = 10
Output: 12
Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
Example 2:

Input: n = 1
Output: 1
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 

Constraints:

1 <= n <= 1690

*/

class Solution {
    public int nthUglyNumber(int n) {
        int p2 = 0, p3 = 0, p5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++){
            /* 
                2: currentUglyNumber = min(1 * 2, 1 * 3, 1* 5) = 2
                    produced by p2, so p2++ 
                    dp [1, 2]
                3: currentUglyNumber = min(2 * 2, 1 * 3, 1 * 5) = 3
                    produced by p3, so p3++
                    dp [1, 2, 3]
                4: currentUglyNumber = min(2 * 2, 2 * 3, 1 * 5) = 4
                    produced by p2, so p2++
                    dp [1, 2, 3, 4]
                5: currentUglyNumber = min(3 * 2, 2 * 3, 1 * 5) = 5
                    produced by p5, so p5++
                    dp [1, 2, 3, 4, 5]
                6: currentUglyNumber = min(3 * 2, 2 * 3, 2 * 5) = 6
                    produced by p2 AND p3, so p2++ and p3++
                    dp [1, 2, 3, 4, 5, 6]
                7: currentUglyNumber = min(4 * 2, 3 * 3, 2 * 5) = 8
                    produced by p2, so p2++
                    dp [1, 2, 3, 4, 5, 6, 8]
                8: currentUglyNumber = min(5 * 2, 3 * 3, 2 * 5) = 9
                    produced by p3, so p3++
                    dp [1, 2, 3, 4, 5, 6, 8, 9]
                9: currentUglyNumber = min(5 * 2, 4 * 3, 2 * 5) = 10
                    produced by p2 and p5, p2++ and p5++
                    dp [1, 2, 3, 4, 5, 6, 8, 9, 10]
                10: currentUglyNumber = min(8 * 2, 4 * 3, 3 * 5) = 12
                    NOTE the 8, that's the value at index 6
                    produced by p3, p3++
                    dp [1, 2, 3, 4, 5, 6, 8, 9, 10, 12]
                11: currentUglyNumber = min(8 * 2, 5 * 3, 3 * 5) = 15
                    produced by p3 and p5, p3++ and p5++
                    dp [1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15]
                12: currentUglyNumber = min(8 * 2, 8 * 3, 4 * 5) = 16
                    produced by p2, p2++
                    dp [1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16]
                13: currentUglyNumber = min(9 * 2, 8 * 3, 4 * 5) = 18
                    produced by p2, p2++   
                    dp [1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16, 18]
                14: currentUglyNumber = min(10 * 2, 8 * 3, 4 * 5) = 20
                    produced by p2 and p5, p2++ p5++   
                    dp [1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16, 18, 20]
                15: currentUglyNumber = min(12 * 2, 8 * 3, 5 * 5) = 24
                    produced by p2 and p3, p2++ p3++   
                    dp [1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16, 18, 20, 24]
                    
                etc.. 
            */
            int p2Val = dp[p2] * 2;
            int p3Val = dp[p3] * 3;
            int p5Val = dp[p5] * 5;
            int currentUglyNumber = Math.min(p2Val, Math.min(p3Val, p5Val));
            /* 
                move the pointer(s) that produced the currentUglyNumber
                so we don't consider that value again
            */
            if (currentUglyNumber == p2Val) p2++;
            if (currentUglyNumber == p3Val) p3++;
            if (currentUglyNumber == p5Val) p5++;
            dp[i] = currentUglyNumber;
        }
        return dp[n - 1];
    }
}