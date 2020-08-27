/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode l3 = res;
        int carry = 0;
            
        while(l1 != null || l2 != null){
            int l1Val = l1 == null? 0 : l1.val;
            int l2Val = l2 == null? 0 : l2.val;
            
            int sum = l1Val + l2Val + carry;
            carry =  sum / 10;
            int digit =  sum % 10;
            l3.next = new ListNode(digit);
            l3 = l3.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        
        if(carry > 0){
            l3.next = new ListNode(1);
            l3 = l3.next;
        }
        
        
        return res.next;
    }
}