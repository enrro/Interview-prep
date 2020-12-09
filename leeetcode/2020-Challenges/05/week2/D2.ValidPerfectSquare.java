/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true
Example 2:

Input: 14
Output: false
*/
class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 0 || num == Integer.MAX_VALUE) return false;
        if(num == 1) return true;
        
        double res = 0;
        int base = 2;
        do{
            
            if((res = logOfBase(base++,num)) == 2){
                return true;
            }
            
        }while(res > 1);
        
        return false;
    }
    
    public double logOfBase(int base, int num) {
        return Math.log(num) / Math.log(base);
    }
}