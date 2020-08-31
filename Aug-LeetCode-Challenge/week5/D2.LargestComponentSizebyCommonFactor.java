/*
Given a non-empty array of unique positive integers A, consider the following graph:

There are A.length nodes, labelled A[0] to A[A.length - 1];
There is an edge between A[i] and A[j] if and only if A[i] and A[j] share a common factor greater than 1.
Return the size of the largest connected component in the graph.

 

Example 1:

Input: [4,6,15,35]
Output: 4

Example 2:

Input: [20,50,9,63]
Output: 2

Example 3:

Input: [2,3,6,7,4,12,21,39]
Output: 8

Note:

1 <= A.length <= 20000
1 <= A[i] <= 100000
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/553/week-5-august-29th-august-31st/3442/
we use the union-find algorithm for this problem.
*/
class Solution {
    // find the parent. if he has no parent then return the number itself.
    // else return the find(parent of x). so continue until you reach the top
    int find(int x, int[] parent){
        if(parent[x] ==-1)
            return x;
        parent[x] = find(parent[x], parent);
        return parent[x];
    }
    
    // if both parents are different then do a union from one to another.
    void union(int x, int y, int[] parent){
        int xp = find(x, parent);
        int yp = find(y, parent);
        System.out.println("xp " + xp+ " yp " + yp);
        if(xp != yp)
            parent[yp] = xp;
        
    }
    
    public int largestComponentSize(int[] A) {
        int[] parent = new int[100001];
        for(int i = 0; i < 100001; i++){
            parent[i] = -1;
        }
        
        for(int x : A){
            for(int factor = 2; factor <= Math.sqrt(x); ++factor){
                if(x % factor == 0){
                    //System.out.println("number: " + x + " factor: "
                    //                   + factor  +  " factor/number: " + (x/factor));
                    union(factor, x, parent);
                    union(x,x/factor,parent);
                }
            }
        }
        
        int count = 0; 
        Map<Integer,Integer> cache = new HashMap();
        for(int x : A){
            int xp = find(x, parent);
            count = Math.max(count, 1 + cache.getOrDefault(xp, 0));
            cache.put(xp,1+ cache.getOrDefault(xp,0));
        }
        return count;
    }
}