/*
There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.

When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.

Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.

 

Example 1:

Input: rooms = [[1],[2],[3],[]]
Output: true
Explanation: 
We visit room 0 and pick up key 1.
We then visit room 1 and pick up key 2.
We then visit room 2 and pick up key 3.
We then visit room 3.
Since we were able to visit every room, we return true.
Example 2:

Input: rooms = [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can not enter room number 2 since the only key that unlocks it is in that room.
 

Constraints:

n == rooms.length
2 <= n <= 1000
0 <= rooms[i].length <= 1000
1 <= sum(rooms[i].length) <= 3000
0 <= rooms[i][j] < n
All the values of rooms[i] are unique.
https://leetcode.com/problems/keys-and-rooms/
*/

//dfs approach
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> currentPath = new Stack<>();
        
        currentPath.add(0);
        visited.add(0);
        
        while(!currentPath.isEmpty()){
            int top = currentPath.pop();
            for(int key: rooms.get(top)){
                if(!visited.contains(key)){
                    visited.add(key);
                    currentPath.push(key);
                    
                    if(rooms.size() == visited.size()) return true;
                }
            }
            
        }
        
        return rooms.size() == visited.size();
    }
    
}

// same approach but replaced the visited condition contains
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> dfs = new Stack<>();
        
        dfs.push(0);
        visited.add(0);
        
        while(!dfs.isEmpty()){
            int room = dfs.pop();
            for(int key : rooms.get(room)){
                if(visited.add(key)){
                    dfs.push(key);
                    
                    if(visited.size() == rooms.size()) return true;
                }
            }
        }
        
        return false;
    }
}