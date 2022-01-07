/**
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:


Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
 

Constraints:

The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000
https://leetcode.com/explore/interview/card/facebook/6/linked-list/3021/
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6;
        ListNode slow = head;
        ListNode fast = head;
        // find the middlepont. 
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
        }
        
        ListNode head2 = reverseList(slow.next);
        // 1 -> 2 -> 3 -> 4 -> null
        // 6 -> 5 -> -----^
        System.out.println(slow.next.val);
        slow.next = null;
        // 1 -> 2 -> 3 -> null
        // 6 -> 5 -> 4 -> null
        
        // Link the two halves together
        while (head != null && head2 != null) {
            ListNode tmp1 = head.next;  // 2
            ListNode tmp2 = head2.next; // 5

            head2.next = head.next; // 6 -> 2
            head.next = head2; // 1 -> 6
            // 1-> 6 -> 2 -> 3 -> null
            head = tmp1;
            head2 = tmp2;
            
        }
        return;
    }
    
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, next = null;
        ListNode curr = head;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}