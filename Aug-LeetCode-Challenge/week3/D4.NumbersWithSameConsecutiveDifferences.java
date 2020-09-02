/*
Return all non-negative integers of length N such that the absolute difference between every two consecutive digits is K.

Note that every number in the answer must not have leading zeros except for the number 0 itself. For example, 01 has one leading zero and is invalid, but 0 is valid.

You may return the answer in any order.

 

Example 1:

Input: N = 3, K = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes.
Example 2:

Input: N = 2, K = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 

Note:

1 <= N <= 9
0 <= K <= 9
tips to get good with dp and recursion.
For DP, the main part is Breaking the a function f(n) to its components f(n1), f(n2) ... where n1,n2,... < n.
Once you are able to write a Recursive solution, then Memoizing them should not be that tough. When encountered with any problem, try to think once what is n = 1, Once I solve for n=1, the base case, now how to get the solution when n=2, and so on... Try to break the problem recursively.
That's why it is important to start with Easier problems of these topics, and then gain fluency and move to medium problems. 
For Trees also You should be good in Recursion. Many Tree problems involve some fluency in Recursion.
So, I see a pattern here. Both DP and Tree problems requires good command over Recursion. You may be lacking in Recursion fluency.

So, to summarize I would recommend starting with Easy Recursion problems, then some medium recursion problems. This should help in DP, Trees and DFS-based problems.

https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3428/
*/

class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        if(N == 1) ll.add(0);
        
        for(int d = 1; d < 10; d++){
            dfs(d,N-1,K,ll);
        }
        
        int[] array = ll.stream().mapToInt(i->i).toArray();
        return array;
    }
    
    public void dfs(int num, int N, int K, LinkedList<Integer> ll){
        if(N == 0){
            ll.add(num);
            return;
        }
        int lastDigit = num%10;
        if(lastDigit >= K) dfs(num*10+lastDigit - K, N-1,K, ll );
        if(K > 0 && lastDigit + K < 10)dfs(num*10+lastDigit + K, N-1,K, ll );
    }
}