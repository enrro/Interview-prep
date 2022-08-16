/**
An attendance record for a student can be represented as a string where each character signifies whether the student was absent, late, or present on that day. The record only contains the following three characters:

'A': Absent.
'L': Late.
'P': Present.
Any student is eligible for an attendance award if they meet both of the following criteria:

The student was absent ('A') for strictly fewer than 2 days total.
The student was never late ('L') for 3 or more consecutive days.
Given an integer n, return the number of possible attendance records of length n that make a student eligible for an attendance award. The answer may be very large, so return it modulo 109 + 7.

 

Example 1:

Input: n = 2
Output: 8
Explanation: There are 8 records with length 2 that are eligible for an award:
"PP", "AP", "PA", "LP", "PL", "AL", "LA", "LL"
Only "AA" is not eligible because there are 2 absences (there need to be fewer than 2).
Example 2:

Input: n = 1
Output: 3
Example 3:

Input: n = 10101
Output: 183236316
https://leetcode.com/problems/student-attendance-record-ii/
 */

/**
approach
https://leetcode.com/problems/student-attendance-record-ii/discuss/101643/Share-my-O(n)-C%2B%2B-DP-solution-with-thinking-process-and-explanation */
 class Solution {
    public int checkRecord(int n)
    {      
        if(n == 1) return 3;
        if(n == 2) return 8;
        int m = 1000000007;
        int[] A = new int [n];
        int[] P = new int [n];
        int[] L = new int [n];
        
        P[0] = 1;
        L[0] = 1;
        L[1] = 3;
        A[0] = 1;
        A[1] = 2;
        A[2] = 4;
        
        
        
        for(int i = 1; i < n; i++)
        {
            A[i - 1] %= m;
            P[i - 1] %= m;
            L[i - 1] %= m;
            
            P[i] = ((A[i - 1] + P[i - 1]) % m + L[i - 1]) % m;
            
            if(i > 1) L[i] = ((A[i - 1] + P[i - 1]) % m + (A[i - 2] + P[i - 2]) % m) % m;
            
            if(i > 2) A[i] = ((A[i - 1] + A[i - 2]) % m + A[i - 3]) % m;
        }
        
        return ((A[n - 1] % m + P[n - 1] % m) % m + L[n - 1] % m) % m;
    }    
}