/*
Write an algorithm to determine if a number n is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Return True if n is a happy number, and False if not.

Example: 

Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
*/



class Solution {
    func isHappy(_ n: Int) -> Bool {
        var a = n
        var b = 0
        var arr: [Int] = []
        while !arr.contains(a) && a != 1 {
            arr.append(a)
            a = digitSum(a)
            //print(a)
        } 
        if a == 1{
            return true
        }
        else{
            return false
        }
            
    }
    
    func digitSum(_ num: Int) -> Int {
        var n = num
        var sum = 0
        while n > 0 {
            sum += Int(pow(Double(n % 10), 2)) // Add least significant digit ...
            n /= 10   // ... and remove it from the number. 
        }
        return sum
    }
}