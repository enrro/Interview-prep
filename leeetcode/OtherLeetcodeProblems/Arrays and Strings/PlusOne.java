/*Given a non-empty array of digits representing a non-negative integer, increment one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

 

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Example 3:

Input: digits = [0]
Output: [1]
 

Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9
https://leetcode.com/explore/interview/card/google/59/array-and-strings/339/
*/

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n-1; i >= 0; i--){
            // you are done you found the missing digit
            if(digits[i] < 9){
                digits[i] = digits[i]+1;
                return digits;
            }
            // lets keep looking for it
            digits[i] = 0;
        }
        // if we are here is because the number was really a lot of 9s.
        int[] otherDigits = new int[n+1];
        otherDigits[0] = 1;
        return otherDigits;
    }
}

// not so efficient but intuitive
class Solution {
    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length];
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--){
            int digit = digits[i] + carry;
            carry = digit / 10;
            digit %= 10; 
            res[i] = digit;
        }
        
        if(carry == 1){
            res = new int[res.length + 1];
            res[0] = 1;
        }
        
        return res;
    }
}