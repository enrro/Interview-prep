/*
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
Note:

The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...
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
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        boolean isOdd = true;
        ListNode odd = new ListNode(head.val);
        ListNode even = new ListNode(head.val);
        ListNode ohead = odd;
        ListNode ehead = even;
        
        ListNode iter = head;
        
        while(iter != null){
            ListNode curr = new ListNode(iter.val);
            if(isOdd){
                odd.next = curr;
                odd = odd.next;
            }else{
                even.next = curr;
                even = even.next;
            }
            isOdd = !isOdd;
            iter = iter.next;
            
        }
        
        if(ehead.next != null){
            ListNode c= new ListNode(ehead.next.val,ehead.next.next);
            odd.next = c;
        }
         
        return ohead.next;
    }
}