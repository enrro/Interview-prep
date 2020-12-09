/*
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: [5,7]
Output: 4
Example 2:

Input: [0,1]
Output: 0
*/
class Solution {
    public int rangeBitwiseAnd(int a, int b) {
        // Flip the LSB of b.
        // And check if the new number is in range(a < number < b) or not
        while(a < b){  
            // -b is the 2's complement of b when do bitwise or with b  
            //we get LSB and we subtract that from b  

            System.out.println(Integer.toBinaryString(b));
            System.out.println(Integer.toBinaryString(-b));
            
            b -= (b & -b);  
        }  
        return b;
        
    }
}

