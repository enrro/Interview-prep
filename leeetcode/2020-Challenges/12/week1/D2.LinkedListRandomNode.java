/*
Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

Example:

// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();
https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/569/week-1-december-1st-december-7th/3552/
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode head; 
    Random random;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    
    /*
    Approach. In this problem we are using the principle that for n numbers if you need a random number you need a 1/n posibilities. of it happening
    for n  where n is 1 then the possibility of it happening is  1/1, 2 == 1/2, 3 == 1/3, 4 = 1/4, n = 1/n. to represent 1/4. 1/4 is equals to 
    (1/2) * (2/3) * (3/4) = 1/4. 
    thus demostrating that the possibility of a result having the same possibility is the mult of every element up to that element
    */
    public Solution(ListNode head) {
        this.head = head;
        random = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode temp = head;
        int res = temp.val;
        for(int i = 1; temp.next != null; i++){
            temp = temp.next;
            if(random.nextInt(i+1) == i) res = temp.val;
        }
        
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */