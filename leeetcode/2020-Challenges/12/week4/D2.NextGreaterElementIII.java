/*
Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.

Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.

 

Example 1:

Input: n = 12
Output: 21
Example 2:

Input: n = 21
Output: -1
 

Constraints:

1 <= n <= 231 - 1
*/

/*
approach
characters in numbers that are in increasing order and cant be changed look like a line 
with negative sloope in a Cartesian coordinate system. take for example 432.

if this does not hold it means there is a number that is larger than this one and can be 
formed with the same digits. to find the inmediante next number larger than this iterate
from right to left and find the first number(a) that dosnt hold the above mentioned 
property, this is the first number to swap, next restat your search but now for a number 
that is larger that the first(b). this 2 values are to be changed. now we have changed the 
smallest posible value with the largest one. 

but we know that all of the other elements to the right of a - 1 are in increasing order 
and therefore there exists a smaller number for them to be array in. so we reverse them. 


1,5,8,4,7,6,5,3,1
      ^     ^

1,5,8,5,7,6,4,3,1
      ^

1,5,8,5,1,3,4,6,7
*/

class Solution {
    
    public int nextGreaterElement(int n) {
        char[] ch = ("" + n).toCharArray();
        int i = ch.length - 2;
        while(i >= 0 && ch[i] >= ch[i+1])i--;
            
        if(i == -1) return -1;
        int j = ch.length - 1;
        
        while(j > i && ch[j] <= ch[i])j--;
        swap(ch, i, j);
        reverse(ch, i + 1);
        
        try{
            return Integer.parseInt(new String(ch)); // > Integer.MAX_VALUE
        }catch(Exception e){
            return -1;
        }
    }
    
    public void reverse(char[] ch, int start){
        int l = start, r = ch.length - 1;
        while(l < r){
            swap(ch, l, r);
            l++;
            r--;
        }
    }
    
    
    public void swap(char[] ch, int i, int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp; 
    }
}