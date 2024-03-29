/*
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

 

Example 1:


Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
Example 2:

Input: head = [2,1], x = 2
Output: [1,2]
 

Constraints:

The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200
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
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode();
        ListNode lessThan = lessHead;
        ListNode moreHead = new ListNode();
        ListNode moreThan =  moreHead;
        
        while(head != null){
            if(head.val >= x){
                moreThan.next = new ListNode(head.val);
                moreThan = moreThan.next;
            }
            else{
                lessThan.next = new ListNode(head.val);
                lessThan = lessThan.next;
            }
            head = head.next;
        }
        
        lessThan.next = moreHead.next;
        
        return lessHead.next;
    }
}


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
    public ListNode partition(ListNode head, int x) {
        ListNode lessdummyHead = new ListNode();
        ListNode moredummyHead = new ListNode();
        ListNode currLess = lessdummyHead;
        ListNode currMore = moredummyHead;
        
        while(head != null){
            if(head.val < x){
                currLess.next = head;
                currLess = currLess.next;
            }else if(head.val >= x){
                currMore.next = head;
                currMore = head;
            }
            head = head.next;
        }
        currMore.next = null;
        currLess.next = moredummyHead.next;
        return lessdummyHead.next;
    }
}