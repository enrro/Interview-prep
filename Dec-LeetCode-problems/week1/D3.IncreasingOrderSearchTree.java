/*
Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.

 

Example 1:


Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
Example 2:


Input: root = [5,1,7]
Output: [1,null,5,null,7]
 

Constraints:

The number of nodes in the given tree will be in the range [1, 100].
0 <= Node.val <= 1000
https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/569/week-1-december-1st-december-7th/3553/
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 /*
 approach
 innorder traversal traverse the tree just like we want it. 
 the challenge in this problem is to keep a tree head and a
 tree iterator, 
 */

class Solution {
    TreeNode output;
    public TreeNode increasingBST(TreeNode root) {
        output = new TreeNode(0);
        TreeNode head = output;
        inorder(root);
        return head.right;
    }
    
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        
        // System.out.println(root.val);
        TreeNode temp = new TreeNode(root.val);
        output.right = temp; 
        output = output.right;
        
        inorder(root.right);
    }
}