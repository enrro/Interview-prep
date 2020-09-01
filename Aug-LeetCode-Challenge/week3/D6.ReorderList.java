/*Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3430/
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
    public void reorderList(ListNode head) {
        if(head == null)return;
        Deque<ListNode> deque = new LinkedList<ListNode>();
        boolean even = true;
        ListNode iterator = head;
        
        while(iterator != null){
            deque.addFirst(iterator);
            iterator = iterator.next;
        }
        
        ListNode next = deque.pollLast();
        head = next;
        head.next = null;

        while(!deque.isEmpty()){
            if(even){
                next = deque.pollFirst();
            }else{
                next = deque.pollLast();
            }
            
            even = !even;
            
            head.next = next;
            head = head.next;
            head.next = null;
        }
        
    }
}