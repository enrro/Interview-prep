/*
You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]
Example 2:

Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]
Example 3:

Input: head = [1], k = 1
Output: [1]
Example 4:

Input: head = [1,2], k = 1
Output: [2,1]
Example 5:

Input: head = [1,2,3], k = 2
Output: [1,2,3]
 

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 105
0 <= Node.val <= 100
https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp1 = head;
        ListNode temp2 = head;
        int temp;
        
        ListNode explorer = head;
        int tlen = 1;
        
        while(explorer != null){
            if(tlen == k){
                temp1 = explorer;
            }
            
            explorer = explorer.next;
            tlen++;
        }
        
        for(int i = 1; i < tlen - k; i++){
            temp2 = temp2.next;
        }
        
        
        // System.out.println(temp1.val);
        // System.out.println(temp2.val);
        temp = temp1.val;
        temp1.val = temp2.val;
        temp2.val = temp;
        
        
        return head;
    }
}