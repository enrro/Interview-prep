/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

 

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
 

Constraints:

1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3013/
*/


/*Time complexity is O(m*n),*/

/**
approach
Start from right to left, perform multiplication on every pair of digits, and add them together. Let's draw the process!

   123 x
    45
   ---
    15
   10
  05
   12
  08
 04
------
  5535

first numbers is index i
second number index is i + 1

 */
class Solution {
    public String multiply(String num1, String num2) {
        int n = num1.length(), m = num2.length();
        int[] pos = new int[n + m];
        StringBuilder sb = new StringBuilder();
        System.out.println("n " + n + " m " + m);
        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                System.out.println("i " + i + " j " + j);
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
                int p1 = i + j;
                int p2 = i + j + 1; // we have one spare position on array n + m. i = n - 1 and j = m - 1 which is n + m - 1; add + 1 and you access the last index.
                int sum = mul + pos[p2]; // the sum is equals to the digit of the previous decimal + the current result of the multiplication

                pos[p1] += sum / 10; // tens
                pos[p2] = (sum) % 10; // units
            }
            
        }
        
        // read from left to right. ignore first value if its 0.
        for(int p : pos) {
            if(!(sb.length() == 0 && p == 0)){
                sb.append(p);
            }
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}