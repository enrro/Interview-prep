/**
A certain bug's home is on the x-axis at position x. Help them get there from position 0.

The bug jumps according to the following rules:

It can jump exactly a positions forward (to the right).
It can jump exactly b positions backward (to the left).
It cannot jump backward twice in a row.
It cannot jump to any forbidden positions.
The bug may jump forward beyond its home, but it cannot jump to positions numbered with negative integers.

Given an array of integers forbidden, where forbidden[i] means that the bug cannot jump to the position forbidden[i], and integers a, b, and x, return the minimum number of jumps needed for the bug to reach its home. If there is no possible sequence of jumps that lands the bug on position x, return -1.

 

Example 1:

Input: forbidden = [14,4,18,1,15], a = 3, b = 15, x = 9
Output: 3
Explanation: 3 jumps forward (0 -> 3 -> 6 -> 9) will get the bug home.
Example 2:

Input: forbidden = [8,3,16,6,12,20], a = 15, b = 13, x = 11
Output: -1
Example 3:

Input: forbidden = [1,6,2,14,5,17,4], a = 16, b = 9, x = 7
Output: 2
Explanation: One jump forward (0 -> 16) then one jump backward (16 -> 7) will get the bug home.
 

Constraints:

1 <= forbidden.length <= 1000
1 <= a, b, forbidden[i] <= 2000
0 <= x <= 2000
All the elements in forbidden are distinct.
Position x is not forbidden. 

https://leetcode.com/problems/minimum-jumps-to-reach-home/
*/

/*
approach
Use 0/True and 1/False to indicate forward and backward directions, respectively;
The bug at most need to reach furthest = max(x, forbideen) + a + b in order to arrive at x, hence the range of the position of the bug is [0, furthest];
Use a Queue to maintain the vectors of the bug, use a Set to avoid forbidden positions and duplicates;

proof of boundary furthest
Assume max(forbidden) > x, and there's a route that must pass a point R to the right of forbidden, then the bug must jump back to the left of the max forbidden in order to reach x. if R is max forbidden + b, then it cannot jump back to the left of max forbidden, and it must jump one more step to right in order to be able to jump back to the left of max forbidden, that is max forbidden + b + a.
if x > max(forbidden), and there's a route that must pass a point R to the right of x, then the bug must jump back too. currently don't know how to proof the boundary is x +a +b.
*/
class Solution {
public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int steps = 0, furthest = x + a + b;
        Queue<Pair<Integer, Integer>> q = new LinkedList();
        q.offer(new Pair(0, 0)); // direction & position;
        Set<Pair<Integer, Integer>> seen = new HashSet<>(q);
        for (int pos : forbidden) {
            seen.add(new Pair(0, pos));
            seen.add(new Pair(1, pos));
            furthest = Math.max(furthest, pos + a + b);
        }
        while (!q.isEmpty()) {
            for (int sz = q.size(); sz > 0; --sz) {
                Pair<Integer, Integer> p = q.poll();
                int dir = p.getKey(), pos = p.getValue();
                if (pos == x) {
                    return steps;
                }
                Pair<Integer, Integer> forward = new Pair<>(0, pos + a), backward = new Pair<>(1, pos - b);
                if (pos + a <= furthest && seen.add(forward)) {
                    q.offer(forward);
                }
                if (dir == 0 && pos - b >= 0 && seen.add(backward)) {
                    q.offer(backward);
                }
            }
            ++steps;
        }
        return -1;                
    }
}