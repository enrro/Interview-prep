/*
Given a function rand7 which generates a uniform random integer in the range 1 to 7, write a function rand10 which generates a uniform random integer in the range 1 to 10.

Do NOT use system's Math.random().

 

Example 1:

Input: 1
Output: [7]
Example 2:

Input: 2
Output: [8,4]
Example 3:

Input: 3
Output: [8,1,10]
 

Note:

rand7 is predefined.
Each testcase has one argument: n, the number of times that rand10 is called.
 

Follow up:

What is the expected value for the number of calls to rand7() function?
Could you minimize the number of calls to rand7()?
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3439/
*/
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */

/*
approach.
we have a random generator from 1-7. we can use this to map this numbers to 1-10. how? 
use 2 variables. the first dictated the direction and the second dictates the magnitude. 
variable 1 is capped 1-6. so we can have equal possibilities of chosing either direction
variable 2 is capped 1-5. so we have the corresponding magnitud. 
now we only need the magnitud and the offset that is the direction to select 1-10
*/
class Solution extends SolBase {
    public int rand10() {
        int v1 = rand7(), v2 = rand7();
        while(v1 > 5) v1 = rand7();
        while(v2 == 7 ) v2 = rand7();
        return (v2 <= 3) ? v1 : v1 + 5;
    }
}