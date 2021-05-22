/*
Count the number of prime numbers less than a non-negative number, n.

 

Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
Example 2:

Input: n = 0
Output: 0
Example 3:

Input: n = 1
Output: 0
 

Constraints:

0 <= n <= 5 * 106
*/

class Solution {
    // complexity O(log(log(n)))
    // approach Sieve of Eratosthenes
    //https://leetcode.com/problems/count-primes/discuss/473021/Time-Complexity-O(log(log(n)
    
    public int countPrimes(int n) {
        boolean[] noPrime = new boolean[n];
        int count = 0;
        for(int i = 2; i < n; i++){
            if(!noPrime[i]){
                count++;
                for(int j = 2; i * j < n; j++){
                    noPrime[i * j] = true;
                }
                
            }
        }
        
        return count;
    }
}